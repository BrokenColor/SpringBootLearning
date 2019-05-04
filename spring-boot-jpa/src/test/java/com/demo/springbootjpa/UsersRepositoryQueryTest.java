package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.dao.UsersRepositoryBy;
import com.demo.springbootjpa.dao.UsersRepositoryQueryAnnotation;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: GWL
 * @Description:测试类
 * @Date: Create in 0:12 2019/5/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryQueryTest {

   @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

   @Test
   public void testqueryByNameUseHQL(){
       List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("李四");
       System.out.println(list);
   }
}
