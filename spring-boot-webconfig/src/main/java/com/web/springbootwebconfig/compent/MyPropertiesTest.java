package com.web.springbootwebconfig.compent;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:定义class类获取属性
 * <p>
 * Author: GWL
 * Date: Create in 20:00 2020/3/22
 */
@Component
//@PropertySource("classpath:application-dev.properties")//自定义配置文件
@ConfigurationProperties(prefix = "my1")
public class MyPropertiesTest {

    private int age;
    private String name;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
