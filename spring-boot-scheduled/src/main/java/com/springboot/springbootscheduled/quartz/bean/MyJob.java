package com.springboot.springbootscheduled.quartz.bean;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author: GWL
 * @Description: 定义Job方式之一 继承 QuartzJobBean 并实现默认的方法
 * @Date: Create in 11:10 2019/6/20
 */
public class MyJob extends QuartzJobBean {

    HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    /**
     * 任务触发时执行的方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.sayHello();
    }
}
