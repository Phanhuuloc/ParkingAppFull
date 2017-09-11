package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.models.Car;
import com.sungwoo.aps.resp.ModelContainer;
import org.springframework.http.ResponseEntity;

/**
 * @author phloc
 */
public interface CarApi {
    /**
     * Find all car
     *
     * @return a list of car
     */
    ResponseEntity<ModelContainer> findAllCar();

    /**
     * Find a car by uid
     * follow R-A-PIR-03
     *
     * @param uid uid of a car
     * @return car
     */
    Car findCarByUid(int uid);

    /**
     * Create a car
     *
     * @param lng     longtitude coordinate of car
     * @param lat     latitude coordinate of car
     * @param token   car token
     * @param stt     status of car
     * @return uid of the car after created successful
     */
    ResponseEntity createCar(double lng, double lat, String token, int stt);

    /**
     * Update token to a car
     *
     * @param uid   uid of this car
     * @param token the token of car
     * @return uid of the car
     */
    ResponseEntity<String> updateCarToken(int uid, String token);

    /**
     * Handle request car call from device
     *
     * @param carUid
     * @return
     */
    ResponseEntity callCar(int carUid);
}
