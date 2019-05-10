package com.demo.springbootjpa.dao;

import com.demo.springbootjpa.pojo.Girlfriend;
import com.demo.springbootjpa.pojo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: GWL
 * @Description: 参数一 T：当前需要映射的实体
 *  参数二 ID：当前映射的实体中的OID的类型
 * @Date: Create in 23:52 2019/5/9
 */
public interface GirlFriendRepository extends JpaRepository<Girlfriend,Integer> {

}
