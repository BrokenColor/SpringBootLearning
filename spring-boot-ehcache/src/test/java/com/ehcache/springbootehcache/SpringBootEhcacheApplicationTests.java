package com.ehcache.springbootehcache;

import com.ehcache.springbootehcache.pojo.City;
import com.ehcache.springbootehcache.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEhcacheApplicationTests {

    @Autowired
    private CityService cityService;

    @Test
    public void testSave() {
        City city = new City();
        city.setName("北京");
        city.setDescription("欢迎你来挤地铁");
        city.setCreateDate(new Date());
        this.cityService.saveCity(city);
    }

    @Test
    public void testFindById() {
        City city = this.cityService.findCityById(1);
        System.out.println(city);
        this.cityService.findCityById(1);
        System.out.println(city);
    }

}
