package com.mybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mybatis.domain.City;
import com.mybatis.mapper.cluster.CityMapper;
import com.mybatis.service.CityService;

/**
 * @author BrokenColor
 * @data 2018年5月24日
 */
@Service
public class CityserviceImpl implements CityService {

	@Resource
	private CityMapper cityMapper;

	@Override
	public City getCityById(Long id) {
		return cityMapper.getCityById(id);
	}

	@Override
	public List<City> getCityList() {
		return cityMapper.getCityList();
	}

	@Override
	public int add(City city) {
		return cityMapper.add(city);
	}

	@Override
	public int update(Long id, City city) {
		return cityMapper.update(id, city);
	}

	@Override
	public int delete(Long id) {
		return cityMapper.delete(id);
	}

}
