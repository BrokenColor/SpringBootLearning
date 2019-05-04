package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @Author: GWL
 * @Description: Repository @Query
 * @Date: Create in 22:49 2019/5/4
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

    @Query("from Users  where name = ?1")
    List<Users> queryByNameUseHQL(String name);

    /**
     * 原生sql
     * @param name
     * @return
     */
    @Query(value="select * from user where user_name =?1", nativeQuery = true)
    List<Users> queryByNameSQL(String name);

    @Query("update Users set name = ?1 where id = ?2 ")
    @Modifying //需要执行一个更新操作
    void updateUsersNameById(String name ,Integer id);
}
