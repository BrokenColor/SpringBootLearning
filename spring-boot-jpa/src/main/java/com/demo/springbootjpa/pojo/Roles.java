package com.demo.springbootjpa.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: GWL
 * @Description: 角色表
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
    private int roleid;

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

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleid +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
