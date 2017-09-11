//package com.sungwoo.aps.controllers.main;
//
//import com.sungwoo.aps.models.Parking;
//import com.sungwoo.aps.resp.ModelContainer;
//import org.springframework.http.ResponseEntity;
//
///**
// * @author phloc
// */
//public interface ParkingApi {
//
//    /**
//     * Find all parking
//     *
//     * @return a response contain a list parking
//     */
//    ResponseEntity<ModelContainer> findAll();
//
//    /**
//     * Find a parking by uid follow
//     * R-A-PIR-01, R-A-PIR-02
//     *
//     * @param uid the parking uid
//     * @return parking
//     */
//    Parking findParkingByUuid(Integer uid);
//
//    /**
//     * Create a parking area
//     *
//     * @param parkingName Parking name
//     * @param lotName lot name inside parking
//     * @param areaname area name inside lot
//     * @param stt area status
//     * @param ltLat left-top latitude
//     * @param ltLong left-top longtitude
//     * @param rtLat right-top latitude
//     * @param rtLong right-top longtitude
//     * @param lbLat left-bottom latitude
//     * @param lbLong left-bottom longtitude
//     * @param rbLat right-bottom latitude
//     * @param rbLong right-bottom longtitude
//     */
//    void createArea(String parkingName, String lotName, String areaname, int stt, double ltLat, double ltLong,
//                    double rtLat, double rtLong, double lbLat, double lbLong, double rbLat, double rbLong);
//}
