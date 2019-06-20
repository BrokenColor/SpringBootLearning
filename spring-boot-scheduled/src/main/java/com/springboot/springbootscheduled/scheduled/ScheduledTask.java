package com.springboot.springbootscheduled.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * @Author: GWL
 * @Description: @Scheduled 定时任务
 * @Date: Create in 10:46 2019/5/15
 */
@Component
public class ScheduledTask {

    /**
     * cron：通过表达式来配置任务执行时间
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduledMethod(){
        System.out.println("愿你下雨有伞，天黑有灯 "+new java.util.Date());
    }

    /**
     * fixedDelay它的间隔时间是根据上次的任务结束的时候开始计时的。
     * 比如一个方法上设置了fixedDelay=5*1000，那么当该方法某一次执行结束后，开始计算时间，当时间达到5秒，就开始再次执行该方法。
     * @throws Exception
     */
    @Scheduled(fixedDelay = 5000)
    public void scheduledFixedDelay() throws Exception{
        Thread.sleep(5000);
        System.out.println("不乱于心,不困于情,不畏将来,不念过往,如此,安好 "+new java.util.Date());
    }

    /**
     * fixedRate 它的间隔时间是根据上次任务开始的时候计时的。
     * 比如当方法上设置了fiexdRate=5*1000，该执行该方法所花的时间是2秒，那么3秒后就会再次执行该方法。
     *
     * 当方法执行时间 大于 定时间隔时间 时 （单线程）后面得任务阻塞
     */
    @Scheduled(fixedRate = 5000)
    public void scheduledFixedRate() throws Exception{
        Thread.sleep(3000);
        System.out.println("房东的猫 "+new java.util.Date());
    }
}
