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

	public List<City> getCityList();

	public int add(City city);

	public int update(Long id, City city);

	public int delete(Long id);
}
