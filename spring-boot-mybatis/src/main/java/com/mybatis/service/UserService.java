package com.mybatis.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mybatis.domain.User;

/**
 * @author BrokenColor
 * @data 2018年5月11日
 */
public interface UserService {
	
	User getUserById(Long id);
	
	PageInfo<User> selectAll(Integer page,Integer size);
	
	List<User> getUserList();

	int add(User user);

	int update(Long id, User user);

	int delete(Long id);
}
