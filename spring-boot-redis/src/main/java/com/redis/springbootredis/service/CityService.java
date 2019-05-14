package com.redis.springbootredis.service;

import com.redis.springbootredis.pojo.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: GWL
 * @Description: Service接口
 * @Date: Create in 10:49 2019/5/14
 */
public interface CityService {

    List<City> findCityAll();

    City findCityById(Integer id);

    Page<City> findCityByPage(Pageable pageable);

    void saveCity(City city);
}
