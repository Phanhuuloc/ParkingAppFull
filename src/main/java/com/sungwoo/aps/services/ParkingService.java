//package com.sungwoo.aps.services;
//
//import com.sungwoo.aps.models.Parking;
//import com.sungwoo.aps.repo.ParkingRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author phloc
// */
//@Service
//public class ParkingService {
//    final ParkingRepo parkingRepo;
//
//    @Autowired
//    public ParkingService(ParkingRepo parkingRepo) {
//        this.parkingRepo = parkingRepo;
//    }
//
//    @Async
//    public List<Parking> findAll() {
//        return parkingRepo.findAll();
//    }
//
//    @Async
//    public Parking findByUid(Integer uid) {
//        return parkingRepo.findByUid(uid);
//    }
//
//}
