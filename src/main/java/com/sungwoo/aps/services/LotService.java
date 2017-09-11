//package com.sungwoo.aps.services;
//
//import com.sungwoo.aps.models.Lot;
//import com.sungwoo.aps.repo.CarRepo;
//import com.sungwoo.aps.repo.LotRepo;
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
//public class LotService {
//    final LotRepo lotRepo;
//    final CarRepo carRepo;
//
//    @Autowired
//    public LotService(LotRepo lotRepo, CarRepo carRepo) {
//        this.lotRepo = lotRepo;
//        this.carRepo = carRepo;
//    }
//
//    @Async
//    public Lot findByUid(int uid) {
//        return lotRepo.findByUid(uid);
//    }
//
//    public List<Lot> findAll() {
//        return lotRepo.findAll();
//    }
//
//    public List<Lot> findByParkingUid(int uid) {
//        return lotRepo.findByParkingUid(uid);
//    }
//
////    @Async
////    public String requestCarParking(UUID carUid, UUID parkingUid) {
////        Lot lot = lotRepo.findTopByParkingUuidAndStatus(parkingUid, 1);
////        Car car = carRepo.findByUuid(carUid);
////
////        //todo: Send parking request(lot_info + car_info)
////        System.out.println(String.format("Car %s will park on lot: %s", car.getId(), lot.getName()));
////        return String.format("Car %s will park on lot: %s", car.getId(), lot.getName());
////    }
//}
//
