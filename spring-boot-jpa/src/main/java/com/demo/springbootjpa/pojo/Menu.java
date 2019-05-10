package com.demo.springbootjpa.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: GWL
 * @Description: 多对多 菜单表与角色表
 * @Date: Create in 18:47 2019/5/9
 */
@Entity
@Table(name = "t_menu")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private  String menuUrl;

    @Column(name = "menu_fid")
    private int fatherId;

    @ManyToMany(mappedBy = "menus")
    Set<Roles> roles = new HashSet<>();

}
