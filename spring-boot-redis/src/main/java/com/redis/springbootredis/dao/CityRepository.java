package com.redis.springbootredis.dao;

import com.redis.springbootredis.pojo.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 10:49 2019/5/14
 */
public interface CityRepository extends JpaRepository<City,Integer> {
}
