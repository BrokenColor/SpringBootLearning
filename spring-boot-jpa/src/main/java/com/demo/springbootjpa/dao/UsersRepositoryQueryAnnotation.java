package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Users;
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
}
