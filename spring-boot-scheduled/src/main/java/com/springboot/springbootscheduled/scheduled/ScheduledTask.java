package com.springboot.springbootscheduled.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * @Author: GWL
 * @Description: 定时任务
 * @Date: Create in 10:46 2019/5/15
 */
@Component
public class ScheduledTask {

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduledMethod(){
        System.out.println("愿你下雨有伞，天黑有灯 "+new java.util.Date());
    }
}
