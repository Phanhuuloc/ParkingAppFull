package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.commons.AreaStatus;
import com.sungwoo.aps.commons.CarStatus;
import com.sungwoo.aps.models.Area;
import com.sungwoo.aps.models.Car;
import com.sungwoo.aps.models.Gps;
import com.sungwoo.aps.resp.ModelContainer;
import com.sungwoo.aps.resp.PermissionResp;
import com.sungwoo.aps.services.AreaService;
import com.sungwoo.aps.services.CarService;
import com.sungwoo.aps.services.TCPConnection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Area", description = "Area Api", tags = "Area")
@RestController
@RequestMapping("/area")
public class AreaController implements AreaApi {
    private final AreaService areaService;
    private final CarService carService;

    @Autowired
    public AreaController(AreaService areaService, CarService carService) {
        this.areaService = areaService;
        this.carService = carService;
    }

    @Override
    @ApiOperation(value = "Get area info by uid", notes = "Get area info by uid", response = Area.class,
            tags = {"Area",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Area.class)})
    @GetMapping(value = "/all", produces = {"application/json", "text/json"})
    public ResponseEntity findAll() {
        return new ResponseEntity<>(new ModelContainer<>(areaService.findAll()), HttpStatus.OK);
    }

    @Override
    @ApiOperation(value = "Get area info by uid", notes = "Get area info by uid", response = Area.class,
            tags = {"Area",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Area.class)})
    @GetMapping(value = "/{uid}", produces = {"application/json", "text/json"})
    public Area findAreaByUuid(@PathVariable("uid") int uid) {
        return areaService.findByUid(uid);
    }

    @Override
    @ApiOperation(value = "Request parking", notes = "Request parking/pickup", response = ResponseEntity.class,
            tags = {"Area"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
    @PostMapping(value = "/parking", produces = {"application/json", "application/json"})
    public ResponseEntity requestCarParking(@RequestParam("car") int carUid)
            throws JSONException {
        Area area = areaService.findFirstByStatus(AreaStatus.EMPTY.value());
        Car car = carService.findByUid(carUid);
        if (area != null && car.getStatus() == CarStatus.ARRIVED.value()) {
            TCPConnection.Permission resp = areaService.doOnRequestParking(car.getUid(), area.getUid());
            List<Gps> route = DummyRoute.buildRouteA2();
            PermissionResp permissionResp = new PermissionResp(String.format("0x%x", resp.getValue()), resp.getDes());
            return new ResponseEntity<>(new ModelContainer<>(route, permissionResp), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
    }

    @Override
    @ApiOperation(value = "Create parking area", notes = "Create parking area", response = ResponseEntity.class,
            tags = {"Area"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
    @PostMapping(value = "/create", produces = {"application/json", "application/json"})
    public ResponseEntity createArea(String areaName, int status, double ltLat, double ltLong, double rtLat, double rtLong, double lbLat, double lbLong, double rbLat, double rbLong) throws JSONException {
        Area area = areaService.createArea(areaName, status, ltLat, ltLong, rtLat, rtLong, lbLat, lbLong, rbLat, rbLong);
        if (area != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

//    @Override
//    @ApiOperation(value = "Request parking/pickup", notes = "Request parking/pickup", response = ResponseEntity.class,
//            tags = {"Area",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
//    @PostMapping(value = "/move/auto", produces = {"application/json", "application/json"})
//    public ResponseEntity requestCarParkingOrPickup(@RequestParam("car") int carUid, @RequestParam("p") int parkingUid)
//            throws JSONException {
//        Area area = areaService.findTopByLotParkingUidAndStatus(parkingUid, AreaStatus.EMPTY.value());
//        Car car = carService.findByUid(carUid);
//        if (car.getStatus() == CarStatus.ARRIVED.value()) {
//            List<Gps> route = areaService.requestCarParkingOrPickupOnArea(car, area);
//            return new ResponseEntity(new ModelContainer(route, area), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.LOCKED);
//        }
//    }
//
//    @Override
//    @ApiOperation(value = "Request parking/pickup", notes = "Request parking/pickup", response = ResponseEntity.class,
//            tags = {"Area",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
//    @PostMapping(value = "/move", produces = {"application/json", "application/json"})
//    public ResponseEntity requestCarParkingOrPickupOnArea(@RequestParam("car") int carUid, @RequestParam("a") int areaUid)
//            throws JSONException {
//        Area area = areaService.findByUid(areaUid);
//        Car car = carService.findByUid(carUid);
//        if (car.getStatus() == CarStatus.ARRIVED.value()) {
//            List<Gps> route = areaService.requestCarParkingOrPickupOnArea(car, area);
//            return new ResponseEntity(new ModelContainer(route), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.LOCKED);
//        }
//    }
//
//    @Override
//    @ApiOperation(value = "Send notification", notes = "Send notification", response = ResponseEntity.class,
//            tags = {"Area",})
//    @PostMapping(value = "/permission", produces = "application/json")
//    public ResponseEntity requestAreaPermission(@RequestParam int uid) throws JSONException {
//        int status = areaService.getStatus(uid);
//        if (status == 1) {
//            return new ResponseEntity(HttpStatus.ACCEPTED);
//        } else {
//            return new ResponseEntity(HttpStatus.LOCKED);
//        }
//    }
}
