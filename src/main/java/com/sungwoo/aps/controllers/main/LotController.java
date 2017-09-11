//package com.sungwoo.aps.controllers.main;
//
//import com.sungwoo.aps.models.Lot;
//import com.sungwoo.aps.resp.ModelContainer;
//import com.sungwoo.aps.services.AndroidPushNotificationsService;
//import com.sungwoo.aps.services.LotService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Api(value = "Lot", description = "the lot API", tags = "Lot")
//@RequestMapping("/lot")
//@RestController
//public class LotController implements LotApi {
//    private final LotService lotService;
//    private final AndroidPushNotificationsService androidPushNotificationsService;
//
//    @Autowired
//    public LotController(LotService lotService, AndroidPushNotificationsService androidPushNotificationsService) {
//        this.lotService = lotService;
//        this.androidPushNotificationsService = androidPushNotificationsService;
//    }
//
//    @Override
//    @ApiOperation(value = "Get all paking infomatios", notes = "Get all paking infomatios", response = ResponseEntity.class, tags = {"Lot",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
//    @GetMapping(value = "/all", produces = {"application/json", "text/json"})
//    public ResponseEntity<ModelContainer> findAll() {
//        return new ResponseEntity<>(new ModelContainer<>(lotService.findAll()), HttpStatus.OK);
//    }
//
//    @Override
//    @ApiOperation(value = "Get all paking infomatios", notes = "Get all paking infomatios", response = ResponseEntity.class, tags = {"Lot",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ResponseEntity.class)})
//    @GetMapping(value = "/parking", produces = {"application/json", "text/json"})
//    public ResponseEntity<ModelContainer> findAllByParkingUid(int parkingUid) {
//        return new ResponseEntity<>(new ModelContainer<>(lotService.findByParkingUid(parkingUid)), HttpStatus.OK);
//    }
//
//    @Override
//    @ApiOperation(value = "Get lot info by uid", notes = "Get lot info by uid", response = Lot.class, tags = {"Lot",})
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Lot.class)})
//    @GetMapping(value = "/{uid}", produces = {"application/json", "text/json"})
//    public Lot findLotByUuid(@PathVariable("uid") int uid) {
//        return lotService.findByUid(uid);
//    }
//
//}
