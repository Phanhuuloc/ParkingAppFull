package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.services.AndroidPushNotificationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Move", description = "the move status API", tags = "Move")
@RestController
@RequestMapping("/move")
public class NotificationController implements NotificationApi {

    private final AndroidPushNotificationsService notificationsService;

    @Autowired
    public NotificationController(AndroidPushNotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }


    @Override
    @ApiOperation(value = "", notes = "", response = ResponseEntity.class, tags = {"Move",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping(value = "/success")
    public ResponseEntity<String> onCarParkingOrPickupSuccess(@RequestParam("car") int carUid,
                                                              @RequestParam("area") int areaUid) throws JSONException {
        return notificationsService.sendCarBeginOrFinishMoveNotificationToMobile(carUid, areaUid);
    }
}
