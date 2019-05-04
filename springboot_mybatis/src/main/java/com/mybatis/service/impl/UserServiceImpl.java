package com.mybatis.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.domain.User;
import com.mybatis.mapper.master.UserMapper;
import com.mybatis.service.UserService;

/**
 * @author BrokenColor
 * @data 2018年5月11日
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper userMapper;

	@Resource
	private RedisTemplate<String, User> redisTemplate;

	/**
	 * 获取用户逻辑： 如果缓存存在，从缓存中获取用户信息 如果缓存不存在，从 DB 中获取用户信息，然后插入缓存
	 */
	@Override
	public User getUserById(Long id) {
		// 从缓存中获取用户信息
		String key = "user_" + id;
		ValueOperations<String, User> operations = redisTemplate.opsForValue();

		// 缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			User user = operations.get(key);

			LOGGER.info("UserServiceImpl.getUserById() : 从缓存中获取了用户 >> " + user.toString());
			return user;
		}

		// 从 DB 中获取用户信息
		User user = userMapper.getUserById(id);

		// 插入缓存
		operations.set(key, user, 100, TimeUnit.SECONDS);
		LOGGER.info("UserServiceImpl.getUserById() : 用户插入缓存 >> " + user.toString());

		return user;
	}

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	
	@Override
	public PageInfo<User> selectAll(Integer page, Integer size) {
		//开启分页查询，写在查询语句上方
	    //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
	    PageHelper.startPage(page, size);
	    List<User> userInfoList = userMapper.getUserList();
	    PageInfo<User> pageInfo = new PageInfo<>(userInfoList);
	    return pageInfo;
	}

	@Override
	public int add(User user) {
		return userMapper.add(user);
	}

	/**
     * 更新逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
	@Override
	public int update(Long id, User user) {

		int num = userMapper.update(id, user);

		String key = "user_" + id;
		boolean haskey = redisTemplate.hasKey(key);
		if (haskey) {
			redisTemplate.delete(key);

			LOGGER.info("UserServiceImpl.update() : 删除用户缓存 >> " + user.toString());
		}

		return num;
	}

	@Override
	public int delete(Long id) {

		int num = userMapper.delete(id);

		String key = "user_" + id;
		boolean haskey = redisTemplate.hasKey(key);
		if (haskey) {
			redisTemplate.delete(key);

			LOGGER.info("UserServiceImpl.delete() : 删除用户缓存 >> " + id);
		}

		return num;
	}
}
