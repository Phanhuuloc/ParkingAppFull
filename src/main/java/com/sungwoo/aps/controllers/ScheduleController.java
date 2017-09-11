//package com.sungwoo.aps.controllers;
//
//import com.sungwoo.aps.repo.CarRepo;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.ScheduledFuture;
//
//@Api(value = "Scheduler", description = "the Scheduler API", tags = "Schedule")
//@RestController
//@RequestMapping("/schedule")
//public class ScheduleController {
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    public static final CronTrigger EVERY_TEN_SECONDS = new CronTrigger("0/5 * * * * *");
//
//    @Autowired
//    TaskScheduler taskScheduler;
//    @Autowired
//    CarRepo carRepo;
//
//    ScheduledFuture<?> scheduledFuture;
//
//    @PostMapping("/start")
//    ResponseEntity<Void> start() {
//        scheduledFuture = taskScheduler.schedule(printHour(), EVERY_TEN_SECONDS);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping("/stop")
//    ResponseEntity<Void> stop() {
//        scheduledFuture.cancel(false);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    private Runnable printHour() {
//        return () -> {
//            if (carRepo.findByLicense("79B792222").getStatus() == 0) {
//                System.out.println("Stop schedule");
//                stop();
//            } else {
//                System.out.println("The time is " + dateFormat.format(new Date()));
//            }
//        };
//    }
//}
