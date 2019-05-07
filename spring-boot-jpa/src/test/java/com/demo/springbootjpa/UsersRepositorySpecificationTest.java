package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.dao.UsersRepositoryBy;
import com.demo.springbootjpa.dao.UsersRepositorySpecification;
import com.demo.springbootjpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GWL
 * @Description:测试类 JpaSpecificationExecutor
 * @Date: Create in 0:12 2019/5/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositorySpecificationTest {

    @Autowired
    private UsersRepositorySpecification usersRepositorySpecification;

    /**
     * JpaSpecificationExecutor查询测试
     * <p>
     * 单个查询条件
     */
    @Test
    public void testUsersRepositorySpecification() {
        /**
         * Predicate 单个查询条件
         *
         * Root<Users> root：查询对象的属性的封装
         * CriteriaQuery<?> criteriaQuery：封装我们要执行的查询中的各部分的信息，select from order
         * CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> spe = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * where name='王五'
                 *
                 * 查询的条件属性
                 * 条件的值
                 */
                Predicate pre = criteriaBuilder.equal(root.get("name"), "王五");
                return pre;
            }
        };
        List list = this.usersRepositorySpecification.findAll(spe);
        System.out.println(list);
    }


    /**
     * JpaSpecificationExecutor查询测试
     * <p>
     * 多条件查询
     */
    @Test
    public void testUsersRepositorySpecification2() {
        /**
         * Root<Users> root：查询对象的属性的封装
         * CriteriaQuery<?> criteriaQuery：封装我们要执行的查询中的各部分的信息，select from order
         * CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> spe = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * where name='王五' and age=20
                 * 查询的条件属性
                 * 条件的值
                 */
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"), "王五"));
                list.add(criteriaBuilder.equal(root.get("age"), "20"));
                Predicate[] arr = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(arr));
            }
        };
        List list = this.usersRepositorySpecification.findAll(spe);
        System.out.println(list);
    }

    /**
     * JpaSpecificationExecutor查询测试
     * <p>
     * 多条件查询 and+or+排序
     */
    @Test
    public void testUsersRepositorySpecification3() {
        /**
         * Root<Users> root：查询对象的属性的封装
         * CriteriaQuery<?> criteriaQuery：封装我们要执行的查询中的各部分的信息，select from order
         * CriteriaBuilder criteriaBuilder：查询条件的构造器，定义不同的查询条件
         */
        Specification<Users> spe = new Specification<Users>() {
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * where id = 5 or (name='王五' and age=20)
                 */

                return criteriaBuilder.or(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(root.get("name"), "王五"),
                                criteriaBuilder.equal(root.get("age"), 20)),
                        criteriaBuilder.equal(root.get("id"),5));
            }
        };
        //添加排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List list = this.usersRepositorySpecification.findAll(spe,sort);
        System.out.println(list);
    }

}
