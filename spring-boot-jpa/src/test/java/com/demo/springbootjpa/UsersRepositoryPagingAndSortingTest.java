package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepositorypagingAndSorting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: GWL
 * @Description:测试类
 * @Date: Create in 0:12 2019/5/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryPagingAndSortingTest {

    @Autowired
    private UsersRepositorypagingAndSorting usersRepositorypagingAndSorting;

    @Test
    public void testUsersRepositorypagingAndSorting(){
        //order 定义排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        //Sort对象封装排序规则
//        Sort sort = new Sort(order);
//        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Sort sort = Sort.by(order);
//        Sort sort = Sort.by(Sort.Direction.DESC,"id");
       List list = (List) this.usersRepositorypagingAndSorting.findAll(sort);
        System.out.println(list);
    }
}
