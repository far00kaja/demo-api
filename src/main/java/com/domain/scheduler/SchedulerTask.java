package com.domain.scheduler;

import java.text.SimpleDateFormat;


// import org.springframework.scheduling.annotation.Async;
// import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
// @EnableAsync
public class SchedulerTask {

    // @Async
    @Scheduled(cron = "0 * * ? * *")
    // public void myFirstTask() throws InterruptedException {
    public void myFirstTask() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Task executed at " + fmt.format(System.currentTimeMillis()));
        // Thread.sleep(10000);
    }
}
