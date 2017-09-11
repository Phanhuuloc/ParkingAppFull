//package com.sungwoo.aps.controllers.main;
//
//import com.sungwoo.aps.models.Parking;
//import com.sungwoo.aps.resp.ModelContainer;
//import com.sungwoo.aps.services.CreateParkingService;
//import com.sungwoo.aps.services.ParkingService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Api(value = "Parking", description = "the parking API", tags = "Parking")
//@RequestMapping("/parking")
//@RestController
//public class ParkingController implements ParkingApi {
//    private final ParkingService parkingService;
//    private final CreateParkingService createParkingService;
//
//    @Autowired
//    public ParkingController(ParkingService parkingService, CreateParkingService createParkingService) {
//        this.parkingService = parkingService;
//        this.createParkingService = createParkingService;
//    }
//
//    @Override
//    @ApiOperation(value = "Get all paking infomatios", notes = "Get all paking infomatios", response = ResponseEntity.class, tags = {"Parking",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
//    @GetMapping(value = "/all", produces = {"application/json", "text/json"})
//    public ResponseEntity<ModelContainer> findAll() {
//        return new ResponseEntity<>(new ModelContainer<>(parkingService.findAll()), HttpStatus.OK);
//    }
//
//    @Override
//    @ApiOperation(value = "R-A-PIR-01, R-A-PIR-02/Get parking area info by uid", notes = "Get parking info by uid", response = Parking.class, tags = {"Parking",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Parking.class)})
//    @GetMapping(value = "/area", produces = {"application/json", "text/json"})
//    public Parking findParkingByUuid(@RequestParam("uid") Integer uid) {
//        return parkingService.findByUid(uid);
//    }
//
//    @Override
//    @ApiOperation(value = "Create dummy parking", notes = "Create dummy parking", tags = {"Parking",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
//    @PostMapping(value = "/gps", produces = {"application/json", "text/json"})
//    public void createArea(@RequestParam("p") String parkingName, @RequestParam("l") String lotName,
//                           @RequestParam("a") String areaname, @RequestParam("status") int stt,
//                           @RequestParam("ltLat") double ltLat, @RequestParam("ltLong") double ltLong,
//                           @RequestParam("rtLat") double rtLat, @RequestParam("rtLong") double rtLong,
//                           @RequestParam("lbLat") double lbLat, @RequestParam("lbLong") double lbLong,
//                           @RequestParam("rbLat") double rbLat, @RequestParam("rbLong") double rbLong) {
//        createParkingService.fetchGps(parkingName, lotName, areaname, stt, ltLat, ltLong, rtLat, rtLong, lbLat, lbLong, rbLat, rbLong);
//    }
//
//
//}
