package com.mybatis.mapper.cluster;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mybatis.domain.City;

/**
 * @author BrokenColor
 * @data 2018年5月23日
 */
@Mapper
public interface CityMapper {
	
	public City getCityById(@Param("id") Long id);

	public List<City> getCityList();

	public int add(@Param("city") City city);

	public int update(@Param("id") Long id, @Param("city") City city);

	public int delete(@Param("id") Long id);
}
