package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: GWL
 * @Description:测试类
 * @Date: Create in 0:12 2019/5/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testSave() {
        Users users = new Users();
        users.setName("王五");
        users.setAge("20");
        usersRepository.save(users);

    }
}
