package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.dao.UsersRepositoryBy;
import com.demo.springbootjpa.dao.UsersRepositoryQueryAnnotation;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    public void testqueryByNameSQL(){
        List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameSQL("王五");
        System.out.println(list);
    }

    @Test
    @Transactional  //当Transactional与Test一起使用时，事务是自动回滚的
    @Rollback(false) //取消自动回滚
    public void testupdateUsersNameById(){
        this.usersRepositoryQueryAnnotation.updateUsersNameById("王五",3);
    }
}
