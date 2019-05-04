package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @Author: GWL
 * @Description: Repository 接口的方法命名查询
 * @Date: Create in 14:00 2019/5/4
 */
public interface UsersRepositoryBy extends Repository<Users, Integer> {

    //方法的名称必须要遵循驼峰式命名规则findBy(关键字)+属性名称(首字母大写)+查询条件（首字母大写）
    List<Users> findByName(String name);

    List<Users> findByNameAndAge(String name,String age);

    List<Users> findByNameOrAge(String name,String age);

    List<Users> findByNameLike(String name);
}
