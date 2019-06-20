package com.springboot.springbootscheduled.quartz.conf;

import com.springboot.springbootscheduled.quartz.bean.HelloService;
import com.springboot.springbootscheduled.quartz.bean.MyJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * @Author: GWL
 * @Description: Quartz配置类
 *  配置 JobDetail 和 Trigger 触发器
 * @Date: Create in 11:22 2019/6/20
 */
@Configuration
public class QuartzConfig {

    //-----------1--------------
    //JobDetail 的配置有两种方式

    /**
     * 配置方式一 MethodInvokingJobDetailFactoryBean
     * 配置目标 Bean 的名字和目标方法的名字，
     * 这种方式不支持传参。
     * @return
     */
    @Bean
    MethodInvokingJobDetailFactoryBean MethodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setTargetBeanName("myJob1");
        factoryBean.setTargetMethod("sayHello");
        return factoryBean;
    }

    /**
     * 配置方式一 JobDetailFactoryBean
     * 使用 JobDetailFactoryBean 可以配置 JobDetail ，任务类继承自 QuartzJobBean ，
     * 这种方式支持传参，将参数封装在 JobDataMap 中进行传递。
     * @return
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MyJob.class);
        //传参数
        JobDataMap map = new JobDataMap();
        map.put("helloService",new HelloService());
        bean.setJobDataMap(map);
        return bean;
    }

    //-----------2--------------
    //Trigger是指触发器 两种：SimpleTrigger 和 CronTrigger

    /**
     * SimpleTrigger类似于 @Scheduled 的基本用法
     * @return
     */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setStartTime(new Date());
        //重复次数
        bean.setRepeatCount(5);
        //执行毫秒数
        bean.setRepeatInterval(1000);
        //关联JobDetail对象
        bean.setJobDetail(MethodInvokingJobDetailFactoryBean().getObject());
        return bean;
    }

    /**
     * CronTrigger 则类似 @Scheduled 中 cron 表达式的用法。
     * @return
     */
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        bean.setCronExpression("0/10 * * * * ?");
        return bean;
    }

    //-----------3--------------
    /**
     * 创建Scheduler对象
     * @return
     */
    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        //关联Trigger
        bean.setTriggers(simpleTriggerFactoryBean().getObject(),cronTriggerFactoryBean().getObject());
        return bean;
    }
}
