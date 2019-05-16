package com.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 9:54 2019/5/16
 *
 * //@Controller 用于标记在一个类上，使用它标记的类就是一个SpringMVC Controller 对象。
 * 分发处理器将会扫描使用了该注解的类的方法。通俗来说，被Controller标记的类就是一个控制器，这个类中的方法，就是相应的动作
 */
@Controller
public class helloworld {

    /**
     * //@RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。
     * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello(){
        System.out.println("hello");
        Map map = new HashMap();
        map.put("msg","hello");
        return map;
    }
}
