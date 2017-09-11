package com.sungwoo.aps.services;

import com.sungwoo.aps.commons.CarStatus;
import com.sungwoo.aps.models.Area;
import com.sungwoo.aps.models.Car;
import com.sungwoo.aps.models.SungWooModel;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author phloc
 */
@Service
public class AndroidPushNotificationsService {
    final static Logger LOGGER = Logger.getLogger(AndroidPushNotificationsService.class);
    private final String TOPIC = "/topics/global";
    private static final String FIREBASE_SERVER_KEY = "AAAA6sk3dHY:APA91bEe80TK3Jukta8sP1w7dgevuxSrIBO4--dCK7_pqVvg-zUw1mPgr01TFxGtLRCtl-WsNJG_FWfx2XTDHI02nyzNCTfy7EchM2BiibEqPrcs-bENlw66wvcHsOc5PpFOqVlLq4DP";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    private final CarService carService;
    private final AreaService areaService;

    @Autowired
    public AndroidPushNotificationsService(CarService carService, AreaService areaService) {
        this.carService = carService;
        this.areaService = areaService;
    }

    public CompletableFuture<String> send(HttpEntity<String> entity) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);
        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
        return CompletableFuture.completedFuture(firebaseResponse);
    }

//    public ResponseEntity<String> sendNotifyTo(String token) throws JSONException {
//        String to = token == null ? TOPIC : token;
//        Car car = carService.findByLicense("50B2-99999");
//        JSONObject body = buildBody(to);
//
//        JSONObject notification = new JSONObject();
//        notification.put("title", "JSA Notification");
//        if (car.getStatus() == 0) {
//            notification.put("body", "Car is parking");
//        } else if (car.getStatus() == 1) {
//            notification.put("body", "Car is moving");
//        } else {
//            notification.put("body", "Car is pickup");
//        }
//
//        JSONObject data = new JSONObject();
//        data.put("license", car.getLicense());
//        data.put("longtitude", car.getGps().getLon());
//        data.put("lattitude", car.getGps().getLat());
//        data.put("status", car.getStatus());
//
//        body.put("notification", notification);
//        body.put("data", data);
//
//        HttpEntity<String> request = new HttpEntity<>(body.toString());
//
//        CompletableFuture<String> pushNotification = send(request);
//        CompletableFuture.allOf(pushNotification).join();
//
//        try {
//            String firebaseResponse = pushNotification.get();
//            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
//    }

//    public void sendCarBeginOrFinishMoveNotificationToDevice(Car car, Area area, boolean isBeginMove,
//                                                             boolean isParkingCommand) throws JSONException {
//        if (isBeginMove) {
//            if (isParkingCommand) {
//                LOGGER.info("-------> Car begin moving in to area " + area.getName());
//            } else {
//                LOGGER.info("-------> Car begin moving out from area " + area.getName());
//            }
//        } else {
//            LOGGER.info("-------> Car finish moving");
//        }
//
//        String token = car.getToken();
//        JSONObject body = buildBody(token);
//        if (!isBeginMove) {
//            String notify = CarStatus.ARRIVED.reasonPhrase();
//            if (isParkingCommand) {
//                notify = String.format(CarStatus.PARKING.reasonPhrase(), area.getName());
//            }
//            JSONObject notification = buildNotification("APS Notification", notify);
//            body.put("notification", notification);
//        }
//        JSONObject carObj = buildData(car);
//        body.put("data", carObj);
//
//        HttpEntity<String> request = new HttpEntity<>(body.toString());
//
//        CompletableFuture<String> pushNotification = send(request);
//        CompletableFuture.allOf(pushNotification).join();
//
//        try {
//            String firebaseResponse = pushNotification.get();
//            LOGGER.info(firebaseResponse);
//        } catch (InterruptedException | ExecutionException e) {
//            LOGGER.error(e.getMessage());
//        }
//
//        LOGGER.info("Push Notification ERROR!");
//    }

    private JSONObject buildData(SungWooModel model) {
        return model.toJSON();
    }


//    public void sendCarMoveStatusNotificationToDevice(Car car) throws JSONException {
//        LOGGER.info("-----> Status update: Car is moving");
//        String token = car.getToken();
//        JSONObject body = buildBody(token);
////        JSONObject notification = buildNotification("APS Notification", "Car is moving!");
//        JSONObject carObj = buildData(car);
//
////        body.put("notification", notification);
//        body.put("data", carObj);
//
//        HttpEntity<String> request = new HttpEntity<>(body.toString());
//
//        CompletableFuture<String> pushNotification = send(request);
//        CompletableFuture.allOf(pushNotification).join();
//
//        try {
//            String firebaseResponse = pushNotification.get();
//            LOGGER.info(firebaseResponse);
//        } catch (InterruptedException | ExecutionException e) {
//            LOGGER.error(e.getMessage());
//        }
//
//        LOGGER.info("Push Notification ERROR!");
//    }


    private JSONObject buildBody(String token) throws JSONException {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");
        body.put("message", "message");
        return body;
    }

    private JSONObject buildNotification(String title, String body) throws JSONException {
        JSONObject notification = new JSONObject();
        notification.put("title", title);
        notification.put("body", body);
        return notification;
    }

    public ResponseEntity<String> sendCarBeginOrFinishMoveNotificationToMobile(int carUid, int areaUid) throws JSONException {
        Area area = areaService.findByUid(areaUid);
        Car car = carService.findByUid(carUid);
//        if ((area.getStatus() == AreaStatus.EMPTY.value() && car.getStatus() == CarStatus.ARRIVED.value())
//                || (area.getStatus() == AreaStatus.FULL.value() && car.getStatus() == CarStatus.PARKING.value()))
        return pushNotificationToDevice(car, area);
//        else return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> pushNotificationToDevice(Car car, Area area) throws JSONException {
        String token = car.getToken();
        JSONObject body = buildBody(token);

        String notify = CarStatus.values()[car.getStatus()].toString();
        LOGGER.info(String.format("Car finish moving, send %s to server", notify));

        JSONObject notification = buildNotification("APS Notification", notify);
        body.put("notification", notification);

        JSONObject carObj = buildData(car);
        body.put("data", carObj);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            LOGGER.info(firebaseResponse);
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info("Push Notification ERROR!");
        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
