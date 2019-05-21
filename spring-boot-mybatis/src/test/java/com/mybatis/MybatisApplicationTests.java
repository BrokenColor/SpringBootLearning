package com.mybatis;

import com.mybatis.mapper.master.UserMapper;
import com.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private UserService userService;

	@Resource
	private UserMapper umapper;

	@Test
	public void contextLoads() {

		System.out.println(this.umapper.getUserById(8L));
		System.out.println(this.userService.getUserById(8L));
	}

}
