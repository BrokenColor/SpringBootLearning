package com.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.domain.City;

/**
 * @author BrokenColor
 * @data 2018年5月24日
 */
public interface CityService {

	City getCityById(Long id);

	List<City> getCityList();

	int add(City city);

	int update(Long id, City city);

	int delete(Long id);
}
