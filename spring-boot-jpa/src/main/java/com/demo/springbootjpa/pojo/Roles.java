package com.demo.springbootjpa.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: GWL
 * @Description: 角色表 与用户表一对多，角色表与菜单表多对多
 * @Date: Create in 19:06 2019/5/8
 */
@Entity
@Table(name="t_roles")
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private  String roleName;

    @Column(name = "note")
    private String note;

    /**
     * mappedBy:用于双向关联时使用，否则会引起数据不一致的问题。
     *
     * fetch:可取的值有FetchType.EAGER和FetchType.LAZY，前者表示主类被加载时加载，后者表示被访问时才会加载
     */

    @OneToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();

    /**
     * 1.一对一和多对一的@JoinColumn注解的都是在“主控方”，都是本表指向外表的外键名称。
     * 2.一对多的@JoinColumn注解在“被控方”，即一的一方，指的是外表中指向本表的外键名称。
     * 3.多对多中，joinColumns写的都是本表在中间表的外键名称，
     *              inverseJoinColumns写的是另一个表在中间表的外键名称。
     */
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //JoinTable 映射中间表
    //joinColumns 当前表中的主键，关联表中的外键字段
    @JoinTable(name = "t_roles_menu",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private  Set<Menu> menus = new HashSet<>();

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
