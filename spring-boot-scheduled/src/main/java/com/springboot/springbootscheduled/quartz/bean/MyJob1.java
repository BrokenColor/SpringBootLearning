package com.springboot.springbootscheduled.quartz.bean;

import org.springframework.stereotype.Component;

/**
 * @Author: GWL
 * @Description: 定义Job方式之一 直接定义一个Bean
 * @Date: Create in 11:14 2019/6/20
 */
@Component
public class MyJob1 {

    public void sayHello(){
        System.out.println("hello，MyJob1");
    }
}
