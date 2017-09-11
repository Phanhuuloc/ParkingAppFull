package com.sungwoo.aps.services;

import com.sungwoo.aps.models.Area;
import com.sungwoo.aps.repo.AreaRepo;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author phloc
 */
@Service
public class AreaService {
    final static Logger LOGGER = Logger.getLogger(AreaService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final CronTrigger EVERY_FIVE_SECONDS = new CronTrigger("0/5 * * * * *");
    private final AreaRepo areaRepo;

//    @Autowired
//    TaskScheduler taskScheduler;
//
//    private ScheduledFuture<?> scheduledFuture;

    @Autowired
    public AreaService(AreaRepo areaRepo) {
        this.areaRepo = areaRepo;
    }

    public Area findByUid(int uid) {
        return areaRepo.findByUid(uid);
    }

//    public List<Gps> requestCarParkingOrPickupOnArea(Car car, Area area) throws JSONException {
//        List<Gps> route = DummyRoute.buildRouteA2();
//        doOnRequestParkingOrPickup(car, area, route);
//        return route;
//    }

//    private void doOnRequestParkingOrPickup(Car car, Area area, List<Gps> route) throws JSONException {
//        boolean isParkingCommand = true;
//        if (area.getStatus() == AreaStatus.FULL.value()) {
//            isParkingCommand = false;
//            Collections.reverse(route);
//        }
//        LOGGER.info(car.getLon() + "-" + car.getLat());
//
//        //Todo: send tcp/ip request to execute car parking/pickup
//        if (area != null && car.getStatus() == CarStatus.ARRIVED.value()) {
//            executeTCPRequest(TCPConnection.Message.PARKING, area.getUid());
//        } else if (car.getStatus() == CarStatus.PARKING.value()) {
//            executeTCPRequest(TCPConnection.Message.CAR_CALL, car.getUid());
//        }
//
//        //schedule send notification to device after 5 seconds
////        startSchedule(car.getUid(), area.getUid(), route, isParkingCommand);
//
//        //send begin notification to android device
////        notificationsService.sendCarBeginOrFinishMoveNotificationToDevice(car, area, true, isParkingCommand);
//    }

//    private void executeTCPRequest(TCPConnection.Message message, int uid) {
//        TCPConnection.init()
//                .request(message, 1)
//                .build()
//                .execute();
//    }

//    private void startSchedule(UUID carUid, UUID areaUid, List<Gps> route, boolean isParkingCommand) {
//        scheduledFuture = taskScheduler.schedule(pushCarStatusNotification(carUid, areaUid, route, isParkingCommand),
//                EVERY_FIVE_SECONDS);
//    }

//    private void stopSchedule() {
//        scheduledFuture.cancel(false);
//    }

//    private Runnable pushCarStatusNotification(UUID carUid, UUID areaUid, List<Gps> route, boolean isParkingCommand) {
//        return () -> {
//            Car car = carService.findByUid(carUid);
//            Area area = areaRepo.findByUid(areaUid);
//
//            for (int i = 0; i < route.size(); i++) {
//                if (i == route.size() - 1) {
//                    if (isParkingCommand) {
//                        carService.updateCarStatus(car, 0);
//                    } else {
//                        carService.updateCarStatus(car, 2);
//                    }
//                }
//                if (car.getStatus() == 1 && car.getGps().equals(route.get(i))) {
//                    carService.updateCarGps(car, route.get(i + 1));
//                    break;
//                }
//            }
//
//            if (car.getStatus() == 0 || car.getStatus() == 2) {
//                try {
//                    notificationsService.sendCarBeginOrFinishMoveNotificationToDevice(car, area, false, isParkingCommand);
//                    updateAreaStatus(area, (car.getStatus() / 2) ^ 1);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                stopSchedule();
//            } else {
//                try {
//                    notificationsService.sendCarMoveStatusNotificationToDevice(car);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//    }

    private void updateAreaStatus(Area area, int status) {
        area.setStatus(status);
        areaRepo.save(area);
    }

//    public ResponseEntity<String> sendNotifyToToken(String token) throws JSONException {
//        return notificationsService.sendNotifyTo(token);
//    }

    public List<Area> findAll() {
        return areaRepo.findAll();
    }

//    public int getStatus(Integer uid) {
//        return areaRepo.findByUid(uid).getStatus();
//    }
//
//    public Area findTopByLotParkingUidAndStatus(Integer parkingUid, int i) {
//        return areaRepo.findTopByLotParkingUidAndStatus(parkingUid, i);
//    }

    /**
     * Execute parking tcp request
     *
     * @param carId  car uid
     * @param areaId parking uid
     * @throws JSONException
     */
    public TCPConnection.Permission doOnRequestParking(int carId, int areaId) throws JSONException {
        //send tcp/ip request to execute car parking/pickup
        return TCPConnection.init()
                .request(areaId, carId)
                .build()
                .execute();
    }

    /**
     * @param status
     * @return
     */
    public Area findFirstByStatus(int status) {
        return areaRepo.findFirstByStatus(status);
    }

    public Area createArea(String areaname, int status, double ltLat, double ltLong, double rtLat,
                           double rtLong, double lbLat, double lbLong, double rbLat, double rbLong) {
        Area area = areaRepo.findFirstByName(areaname);
        if (area == null) {
            area = new Area(areaname);
        }
        area.setStatus(status);
        area.setLtLat(ltLat);
        area.setLtLong(ltLong);
        area.setRtLat(rtLat);
        area.setRtLong(rtLong);
        area.setLbLat(lbLat);
        area.setLbLong(lbLong);
        area.setRbLat(rbLat);
        area.setRbLong(rbLong);
        areaRepo.saveAndFlush(area);
        return area;
    }
}

