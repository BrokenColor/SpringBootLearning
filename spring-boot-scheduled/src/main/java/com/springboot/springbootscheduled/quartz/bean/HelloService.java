package com.springboot.springbootscheduled.quartz.bean;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 11:34 2019/6/20
 */
@Service
public class HelloService {

    public void sayHello (){
        System.out.println("hello service >>>"+new Date());
    }
}
