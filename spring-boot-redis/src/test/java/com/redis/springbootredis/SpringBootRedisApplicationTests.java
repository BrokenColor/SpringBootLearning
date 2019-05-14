package com.redis.springbootredis;

import com.redis.springbootredis.pojo.City;
import com.redis.springbootredis.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Autowired
    private CityService cityService;

    @Test
    public void testFindCityById() {
        City city  = this.cityService.findCityById(2);
        System.out.println(city);
        City city1  = this.cityService.findCityById(2);
        System.out.println(city1);
    }

}
