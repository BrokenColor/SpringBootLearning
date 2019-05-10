package com.ehcache.springbootehcache.service;

import com.ehcache.springbootehcache.pojo.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: GWL
 * @Description: Service接口
 * @Date: Create in 17:18 2019/5/10
 */
public interface CityService {

    List<City> findCityAll();

    City findCityById(Integer id);

    Page<City> findCityByPage(Pageable pageable);

    void saveCity(City city);
}
