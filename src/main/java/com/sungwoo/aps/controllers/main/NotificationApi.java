package com.sungwoo.aps.controllers.main;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

public interface NotificationApi {
    ResponseEntity<String> onCarParkingOrPickupSuccess(int carUid, int areaUid) throws JSONException;
}
