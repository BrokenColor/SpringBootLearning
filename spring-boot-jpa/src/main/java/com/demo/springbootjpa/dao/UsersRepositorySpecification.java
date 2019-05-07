package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: GWL
 * @Description: 查询 分页排序
 * @Date: Create in 23:52 2019/5/3
 */
public interface UsersRepositorySpecification extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {

}
