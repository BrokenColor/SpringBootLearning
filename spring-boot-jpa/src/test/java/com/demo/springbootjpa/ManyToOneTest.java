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
import java.util.Optional;

/**
 * @Author: GWL
 * @Description: 一对多测试
 * @Date: Create in 19:53 2019/5/8
 *
 * 注意一对多：实体中的外键 在重新totring()方法时 totring()里只要要在其中一方写外键实体类，
 *      否则会循环调用对方从而死循环（java.lang.StackOverFlowError）
 *      如：Users中@Data 生成的toString()方法有所有属性，而Roles 手动重新写toString()中没有Users外键实体类
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
        roles.setRoleName("国王");
        roles.setNote("走向人生巅峰");

        //创建用户
        Users users = new Users();
        users.setName("黑豹");
        users.setAge(60);
        users.setCreateDate(new Date());

        //创建用户
        Users user1 = new Users();
        user1.setName("黑寡妇");
        user1.setAge(60);
        user1.setCreateDate(new Date());

        //关联
        roles.getUsers().add(users);
        roles.getUsers().add(user1);
        users.setRoles(roles);

        //保存
        this.usersRepository.save(users);
    }

    @Test
    public void testManyToOne() {
        Optional opt =  this.usersRepository.findById(15);
        System.out.println(opt.get());
    }
}
