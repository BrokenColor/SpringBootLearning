package com.mybatis.mapper.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mybatis.domain.User;

/**
 * @author BrokenColor
 * @data 2018年5月21日
 */
@Mapper
public interface UserMapper {

	public User getUserById(@Param("id") Long id);

	public List<User> getUserList();

	public int add(@Param("user") User user);

	public int update(@Param("id") Long id, @Param("user") User user);

	public int delete(@Param("id") Long id);
}
