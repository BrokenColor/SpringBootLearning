package com.ehcache.springbootehcache;

import com.ehcache.springbootehcache.pojo.City;
import com.ehcache.springbootehcache.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        city.setName("乌鲁木齐");
        city.setDescription("欢迎你来呼吸新鲜空气");
        city.setCreateDate(new Date());
        this.cityService.saveCity(city);
    }

    @Test
    public void testFindById() {
        //查询两次 查看控制台执行了几次sql语句
        City city = this.cityService.findCityById(2);
        System.out.println(city);
        City city1 = this.cityService.findCityById(2);
        System.out.println(city1);
    }

    @Test
    public void testFindCityByPage() {
        Pageable pageable = PageRequest.of(0,2);

        //查询两次 查看控制台执行了几次sql语句
        System.out.println(this.cityService.findCityByPage(pageable).getTotalElements());

        System.out.println(this.cityService.findCityByPage(pageable).getTotalElements());

        Pageable pageable1 = PageRequest.of(1,2);
        System.out.println(this.cityService.findCityByPage(pageable1).getTotalElements());
    }

    @Test
    public void testFindAll() {
        //多次查询查看控制台sql执行情况
        System.out.println(this.cityService.findCityAll().size());

        City city = new City();
        city.setName("青岛");
        city.setDescription("相约去看海");
        city.setCreateDate(new Date());
        //添加了清除缓存
        this.cityService.saveCity(city);

        System.out.println(this.cityService.findCityAll().size());
    }

}
