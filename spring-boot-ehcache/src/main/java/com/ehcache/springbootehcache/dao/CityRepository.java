package com.ehcache.springbootehcache.dao;

import com.ehcache.springbootehcache.pojo.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 17:49 2019/5/10
 */
public interface CityRepository extends JpaRepository<City,Integer> {
}
