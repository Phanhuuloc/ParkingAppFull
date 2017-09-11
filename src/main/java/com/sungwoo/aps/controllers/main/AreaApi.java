package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.models.Area;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;


/**
 * @author phloc
 */
public interface AreaApi {
    /**
     *
     * @return
     */
    ResponseEntity findAll();

    /**
     * Find an area by it's uid
     *
     * @param uid the uid of the area
     * @return Area
     */
    Area findAreaByUuid(int uid);

    /**
     * Handle request car parking, server chose area auto
     *
     * @param carUid     the uid of the car
     * @return ResponseEntity
     */
    ResponseEntity requestCarParking(int carUid) throws JSONException;

    /**
     *
     * @param areaName
     * @param status
     * @param ltLat
     * @param ltLong
     * @param rtLat
     * @param rtLong
     * @param lbLat
     * @param lbLong
     * @param rbLat
     * @param rbLong
     * @return
     * @throws JSONException
     */
    ResponseEntity createArea(String areaName, int status, double ltLat, double ltLong, double rtLat,
                              double rtLong, double lbLat, double lbLong, double rbLat, double rbLong) throws JSONException;

//    /**
//     * Request Car parking/pickup
//     *
//     * @param carUid     the uid of the car
//     * @param parkingUid the uid of the parking
//     * @return ResponseEntity
//     */
//    ResponseEntity requestCarParkingOrPickup(int carUid, int parkingUid) throws JSONException;
//
//    /**
//     * Request Car parking/pickup
//     *
//     * @param carUid  the uid of the car
//     * @param areaUid the uid of the area
//     * @return ResponseEntity
//     */
//    ResponseEntity requestCarParkingOrPickupOnArea(int carUid, int areaUid) throws JSONException;

//    /**
//     * @param token token of the car
//     * @return ResponseEntity
//     * @throws JSONException
//     */
//    ResponseEntity<String> sendParkingOrPickupRequest(String token) throws JSONException;

//    /**
//     * Request area permission
//     * follow R-S-PR-01 specification
//     *
//     * @param uid token of the car
//     * @return ResponseEntity
//     * @throws JSONException
//     */
//    ResponseEntity requestAreaPermission(int uid) throws JSONException;

}
