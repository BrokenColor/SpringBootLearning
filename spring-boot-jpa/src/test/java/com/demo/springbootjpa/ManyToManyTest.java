package com.demo.springbootjpa;

import com.demo.springbootjpa.dao.RolesRepository;
import com.demo.springbootjpa.dao.UsersRepository;
import com.demo.springbootjpa.pojo.Menu;
import com.demo.springbootjpa.pojo.Roles;
import com.demo.springbootjpa.pojo.Users;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @Author: GWL
 * @Description: 多对多测试
 * @Date: Create in 19:53 2019/5/8
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private RolesRepository rolesRepository;

    @Test
    public void testsave(){
        //创建角色
        Roles roles = new Roles();
        roles.setRoleName("千面佛");
        roles.setNote("凡人皆有一死");

        //创建用户
        Menu menu = new Menu();
        menu.setMenuName("xxx系统管理");
        menu.setFatherId(0);
        menu.setMenuUrl("http://www.baidu.com");

        Menu menu1 = new Menu();
        menu1.setMenuName("项目管理");
        menu1.setFatherId(1);
        menu1.setMenuUrl("http://www.baidu.com");
        //关联
        roles.getMenus().add(menu);
        roles.getMenus().add(menu1);

        menu.getRoles().add(roles);
        menu1.getRoles().add(roles);

        //保存
        this.rolesRepository.save(roles);
    }

    /**
     * com.demo.springbootjpa.pojo.Roles.menus, could not initialize proxy - no Session
     * 延迟加载 Roles类中 加fetch
     */
    @Test
    public void testManyToMany() {
        Optional<Roles> opt =  this.rolesRepository.findById(7);
        System.out.println(opt.get());
        Set<Menu> menus = opt.get().getMenus();
        System.out.println(menus);

    }
}
