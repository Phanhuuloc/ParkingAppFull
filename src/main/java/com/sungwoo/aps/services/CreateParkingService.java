//package com.sungwoo.aps.services;
//
//import com.sungwoo.aps.models.Area;
//import com.sungwoo.aps.models.Car;
//import com.sungwoo.aps.models.Lot;
//import com.sungwoo.aps.models.Parking;
//import com.sungwoo.aps.repo.AreaRepo;
//import com.sungwoo.aps.repo.CarRepo;
//import com.sungwoo.aps.repo.LotRepo;
//import com.sungwoo.aps.repo.ParkingRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author phloc
// */
//@Service
//public class CreateParkingService {
//    private final ParkingRepo parkingRepo;
//    private final LotRepo lotRepo;
//    private final AreaRepo areaRepo;
//    private final CarRepo carRepo;
//
//    @Autowired
//    public CreateParkingService(ParkingRepo parkingRepo, LotRepo lotRepo, AreaRepo areaRepo, CarRepo carRepo) {
//        this.parkingRepo = parkingRepo;
//        this.lotRepo = lotRepo;
//        this.areaRepo = areaRepo;
//        this.carRepo = carRepo;
//    }
//
////    @Async
////    public void fetchParking(String parkingName, String lotName, int areaCount) {
////        Parking parking = parkingRepo.findByName(parkingName);
////        Set lots = new HashSet<>();
////        if (parking == null) {
////            parking = new Parking(UuidUtils.generateUuid(), parkingName);
////        } else {
////            lots = parking.getLots();
////            if (lots == null) {
////                lots = new HashSet<>();
////            }
////        }
////
////        Lot lot = new Lot(UuidUtils.generateUuid(), lotName);
////
////        Set areas = new HashSet<>();
////        for (int i = 1; i <= areaCount; i++) {
////            Area area = new Area(UuidUtils.generateUuid(), lotName + i);
////            areas.add(area);
////            area.setLot(lot);
////        }
////
////        lot.setAreas(areas);
////        lots.add(lot);
////        lot.setParking(parking);
////
////        parking.setLots(lots);
////
////        parkingRepo.save(parking);
////    }
//
//    @Async
//    public void fetchGps(String parkingName, String lotName, String areaname, int status, double ltLat, double ltLong, double rtLat,
//                         double rtLong, double lbLat, double lbLong, double rbLat, double rbLong) {
//        Parking parking = createParking(parkingName);
//        Lot lot = createLot(parking.getUid(), lotName);
//
//        Area area = createArea(parking.getUid(), areaname);
//        area.setStatus(status);
//        area.setLtLat(ltLat);
//        area.setLtLong(ltLong);
//        area.setRtLat(rtLat);
//        area.setRtLong(rtLong);
//        area.setLbLat(lbLat);
//        area.setLbLong(lbLong);
//        area.setRbLat(rbLat);
//        area.setRbLong(rbLong);
//
//        Set<Lot> lots = parking.getLots() != null ? parking.getLots() : new HashSet();
//        Set<Area> areas = lot.getAreas() != null ? lot.getAreas() : new HashSet();
//
//        areas.add(area);
//        area.setLot(lot);
//        lot.setAreas(areas);
//
//        lots.add(lot);
//        lot.setParking(parking);
//        parking.setLots(lots);
//
//        parkingRepo.save(parking);
//    }
//
//    private Parking createParking(String parkingName) {
//        Parking parking = parkingRepo.findByName(parkingName);
//        if (parking == null) {
//            parking = new Parking(parkingName);
//        }
//        return parking;
//    }
//
//    private Lot createLot(int pUid, String lotName) {
//        Lot lot = lotRepo.findByNameAndParkingUid(lotName, pUid);
//        if (lot == null) {
//            lot = new Lot(lotName);
//        }
//        return lot;
//    }
//
//    private Area createArea(int pUid, String areaname) {
//        Area area = areaRepo.findByNameAndLotParkingUid(areaname, pUid);
//        if (area == null) {
//            area = new Area(areaname);
//        }
//
//        return area;
//    }
//
//    public int fetchCar(String license, double lng, double lat, String token, int stt) {
//        Car car = carRepo.findByLicense(license);
//        if (car == null) {
//            car = new Car(license);
//        }
//
//        car.setLat(lat);
//        car.setLon(lng);
//        car.setStatus(stt);
//        carRepo.save(car);
//        return car.getUid();
//    }
//}
