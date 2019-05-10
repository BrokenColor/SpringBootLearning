package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.GirlFriendRepository;
import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.pojo.Girlfriend;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: GWL
 * @Description: 一对一 一个女朋友对应一个程序员（哈哈哈）
 * @Date: Create in 23:18 2019/5/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneTest {

    @Autowired
    private GirlFriendRepository girlFriendRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void testSaveGirlFriend(){
        Girlfriend girlfriend = new Girlfriend();
        girlfriend.setName("小可爱");
        girlfriend.setAge(18);
        girlfriend.setSweet("非常甜");
        girlfriend.setCreateDate(new Date());
        Users users = this.usersRepository.findById(9).get();
        girlfriend.setUser(users);
        this.girlFriendRepository.save(girlfriend);
    }

    @Test
    public void testFindGirlFriend(){

        Girlfriend girlfriend =this.girlFriendRepository.findById(2).get();

        System.out.println(girlfriend);
    }
}
