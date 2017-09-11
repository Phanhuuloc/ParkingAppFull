package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.commons.CarStatus;
import com.sungwoo.aps.models.Car;
import com.sungwoo.aps.models.Gps;
import com.sungwoo.aps.resp.ModelContainer;
import com.sungwoo.aps.resp.PermissionResp;
import com.sungwoo.aps.services.CarService;
import com.sungwoo.aps.services.TCPConnection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Api(value = "Car", description = "the car API", tags = "Car")
@RestController
@RequestMapping("/car")
public class CarController implements CarApi {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Override
    @ApiOperation(value = "Get all car", notes = "Get all car", response = Car.class,
            tags = {"Car",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Car.class)})
    @GetMapping(value = "/all", produces = {"application/json", "text/json"})
    public ResponseEntity<ModelContainer> findAllCar() {
        return new ResponseEntity<>(new ModelContainer<>(carService.findAll()), HttpStatus.OK);
    }

    @Override
    @ApiOperation(value = "Get car info by id", notes = "Get car info by uid", response = Car.class,
            tags = {"Car",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Car.class)})
    @GetMapping(value = "/info/{uid}", produces = {"application/json", "text/json"})
    public Car findCarByUid(@PathVariable("uid") int uid) {
        return carService.findByUid(uid);
    }

    @Override
    @ApiOperation(value = "Get update car info by id", notes = "Get update car info by id", response = UUID.class,
            tags = {"Car",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UUID.class)})
    @PostMapping(value = "/create", produces = {"application/json", "text/json"})
    public ResponseEntity createCar(@RequestParam("lng") double lng,
                                    @RequestParam("lat") double lat,
                                    @RequestParam(value = "tk", required = false) String token,
                                    @RequestParam("status") int stt) {
        int id = carService.fetchCar(lng, lat, token, stt);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    @ApiOperation(value = "Get update car info by id", notes = "Get update car info by id", response = UUID.class,
            tags = {"Car",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UUID.class)})
    @PostMapping(value = "/token", produces = {"application/json", "text/json"})
    public ResponseEntity<String> updateCarToken(@RequestParam("uid") int uid, @RequestParam("token") String token) {
        if (StringUtils.isNotBlank(token)) {
            carService.updateCarToken(uid, token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Token is null", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @ApiOperation(value = "Car call request", notes = "Car call", response = ResponseEntity.class,
            tags = {"R-S-CS-01, R-S-CS-02, R-S-CS-03"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
    @PostMapping(value = "/call", produces = {"application/json", "text/json"})
    public ResponseEntity callCar(@RequestParam("car") int carUid) {
        Car car = carService.findByUid(carUid);
        if (CarStatus.PARKING.value() == car.getStatus()) {
            TCPConnection.Permission resp = carService.carCall(carUid);
            List<Gps> route = DummyRoute.buildRouteA2();
            Collections.reverse(route);
            PermissionResp permissionResp = new PermissionResp(String.format("0x%x", resp.getValue()), resp.getDes());
            return new ResponseEntity<>(new ModelContainer<>(route, permissionResp), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }
    }
}
