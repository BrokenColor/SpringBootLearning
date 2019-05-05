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
	
	public List<User> getUserList();

	public int add(User user);

	public int update(Long id, User user);

	public int delete(Long id);
}
