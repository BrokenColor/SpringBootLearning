package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.pojo.Roles;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: GWL
 * @Description: 一对多测试
 * @Date: Create in 19:53 2019/5/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToOneTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testsave(){
        //创建角色
        Roles roles = new Roles();
        roles.setRoleName("项目经理");
        roles.setNote("走向人生巅峰");

        //创建用户
        Users users = new Users();
        users.setName("铁男");
        users.setAge(100);
        users.setCreateDate(new Date());

        //关联
        roles.getUsers().add(users);
        users.setRoles(roles);

        //保存
        this.usersRepository.save(users);
    }
}
