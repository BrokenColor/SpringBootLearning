package com.demo.springbootjpa.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: GWL
 * @Description: 一对一
 * @Date: Create in 23:10 2019/5/10
 */
@Entity
@Table(name = "t_girlfriend")
@Data
public class Girlfriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_id")
    private int id;

    @Column(name = "g_name")
    private String name;

    @Column(name = "g_age")
    private int age;

    @Column(name = "g_sweet")
    private String sweet;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private java.util.Date createDate;

    @OneToOne
    @JoinColumn(name = "t_boyfriend")
    private Users user;

}
