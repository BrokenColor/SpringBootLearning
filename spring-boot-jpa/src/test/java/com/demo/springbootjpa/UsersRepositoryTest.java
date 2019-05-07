package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.dao.UsersRepositoryBy;
import com.demo.springbootjpa.pojo.Users;
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
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersRepositoryBy usersRepositoryBy;

    @Test
    public void testSave() {
        Users users = new Users();
        users.setName("王五");
        users.setAge(22);
        usersRepository.save(users);

    }

    /**
     * 测试根据命名查询
     */
    @Test
    public void textFindByName(){
        List<Users> list = usersRepositoryBy.findByName("gg");
        System.out.println(list);
    }

    /**
     * and条件查询
     */
    @Test
    public void textFindByNameAndAge(){
        List<Users> list = usersRepositoryBy.findByNameAndAge("gg",23);
        System.out.println(list);
    }

    /**
     * or条件查询
     */
    @Test
    public void textFindByNameOrAge(){
        List<Users> list = usersRepositoryBy.findByNameOrAge("gg",20);
        System.out.println(list);
    }

    /**
     * like条件查询
     */
    @Test
    public void textFindByNameLike(){
        List<Users> list = usersRepositoryBy.findByNameLike("g%");
        System.out.println(list);
    }

    /**
     * between
     * between ?1 and ?2
     */
    @Test
    public void textFindByAgeBetween(){
        List<Users> list = this.usersRepositoryBy.findByAgeBetween(10,100);
        System.out.println(list);
    }

    /**
     * lessthan
     * where x.age < ?1
     */
    @Test
    public void textFindByAgeLessThan(){
        List<Users> list = this.usersRepositoryBy.findByAgeLessThan(20);
        System.out.println(list);
    }

    /**
     * OrderBy
     *
     */
    @Test
    public void textFindOrderByName(){
        List<Users> list = this.usersRepositoryBy.findByAgeOrderByName(20);
        System.out.println(list);
    }

    /**
     * isNull
     */
    @Test
    public void textFindByAgeIsNull(){
        List list = this.usersRepositoryBy.findByAgeIsNull();
        System.out.println(list);
    }

    /**
     * findall
     */
    @Test
    public void textFindAllSort(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List list = this.usersRepository.findAll(sort);
        System.out.println(list);
    }
}
