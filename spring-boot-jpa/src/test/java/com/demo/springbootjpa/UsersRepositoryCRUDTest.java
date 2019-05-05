package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepositoryCRUD;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 12:49 2019/5/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryCRUDTest {

    @Autowired
    private UsersRepositoryCRUD usersRepositoryCRUD;

    /**
     * crud Repository 测试
     * create
     */
    @Test
    public void testUsersRepositoryC() {
        Users users = new Users();
        users.setName("三傻");
        users.setAge(26);
        usersRepositoryCRUD.save(users);
    }

    /**
     * crud Repository 测试
     * update
     */
    @Test
    public void testUsersRepositoryU() {
        Users users = new Users();
        users.setId(8);
        users.setName("三傻");
        users.setAge(36);
        usersRepositoryCRUD.save(users);
    }

    /**
     * crud Repository 测试
     * 查询
     */
    @Test
    public void testUsersRepositoryR() {

        Optional<?> usersOpt = usersRepositoryCRUD.findById(3);
        System.out.println(usersOpt.get());

        List<Users> list = (List) usersRepositoryCRUD.findAll();
        System.out.println(list);
    }
}
