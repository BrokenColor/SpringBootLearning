package com.redis.springbootredis.service.impl;

import com.redis.springbootredis.dao.CityRepository;
import com.redis.springbootredis.pojo.City;
import com.redis.springbootredis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 10:53 2019/5/14
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<City> findCityAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City findCityById(Integer id) {

        //重新设置序列化器
//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        String cityKey ="city_"+id;
        ValueOperations<String,City> operations = redisTemplate.opsForValue();
        // 判断缓存中是否存在
        if (redisTemplate.hasKey(cityKey)){
            City city = operations.get(cityKey);
            return city;
        }
        // 从 DB 中获取
        City city = this.cityRepository.findById(id).get();

        // 添加的缓存中，时间10
        operations.set(cityKey,city,100, TimeUnit.SECONDS);
        return city;
    }

    @Override
    public Page<City> findCityByPage(Pageable pageable) {
        return this.cityRepository.findAll(pageable);
    }

    @Override
    public void saveCity(City city) {
        this.cityRepository.save(city);
    }
}
