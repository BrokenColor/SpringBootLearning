package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: GWL
 * @Description: CRUD
 * @Date: Create in 12:45 2019/5/5
 */

public interface UsersRepositoryCRUD extends CrudRepository<Users,Integer> {

}
