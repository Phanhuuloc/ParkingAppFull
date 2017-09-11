package com.sungwoo.aps.services;

import com.sungwoo.aps.models.Car;
import com.sungwoo.aps.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author phloc
 */
@Service
public class CarService {
    final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> findAll() {
        return carRepo.findAll();
    }

    public Car findByUid(int uid) {
        return carRepo.findByUid(uid);
    }

    public void updateCarToken(int uid, String token) {
        Car car = carRepo.findByUid(uid);
        car.setToken(token);
        carRepo.save(car);
    }

    public int fetchCar(double lng, double lat, String token, int stt) {
        Car car = new Car();
        car.setLat(lat);
        car.setLon(lng);
        car.setStatus(stt);
        carRepo.save(car);
        return car.getUid();
    }

    /**
     * Execute car call tcp request
     *
     * @param carId car id
     */
    public TCPConnection.Permission carCall(int carId) {
        return TCPConnection.init()
                .request(carId)
                .build()
                .execute();
    }
}
