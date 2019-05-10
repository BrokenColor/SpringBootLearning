package com.demo.springbootjpa.pojo;


import lombok.Data;

import javax.persistence.*;

/**
 * @Author: GWL
 * @Description: 用户表
 * @Date: Create in 22:40 2019/5/3
 *  @Entity
 *      对类注释。任何Hibernate映射对象都要有这个注释
 *      持久层将对象映射到数据库，JPA是一种规范，Hibernate是一种实现，可以将POJO映射到数据库。这种类就叫Entity Bean
 *
 * @Table
 *      对类注释。通过它可以为实体指定表(talbe),目录(Catalog)和schema的名字
 *
 * @Data lombok插件注解
 * 我们使用 @Data 注解就可以有下面几个注解的功能：@ToString、@Getter、@Setter、@EqualsAndHashCode、@NoArgsConstructor 。
 *
 */
@Entity
@Table(name="user")
@Data
public class Users {
    /**
     * @Id 声明该属性为主键，指定类的主键
     * @GeneratedValue 指定主建的声明策略，自动生成主键
     *  >>TABLE：数据库产生主键
     *  >>IDENTITY：数据库自增长
     *  >>SEQUENCR ：通过数据库的序列产生主键
     *  >>AUTO：默认选项
     *
     *  @Column 声明该属性与数据库字段的映射关系，Hibernate会自动匹配属性和字段名字相同的，@Column可以修改映射值
     *  @Transitent 若属性非数据库字段，则可以声明该属性与数据库字段的不产生映射关系
     *
     *  一个角色多个用户
     *  @JoinColumn 维护外键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_age")
    private int age;

    /**
     * 在进行实体映射时，有关时间日期类型的类型可以是java.sql包下的java.sql.Date、java.sql.Time 和java.sql.Timestamp，
     * 还有java.util包下的java.util.Date 和 java.util.Calendar类型。
     * 默认情况下，实体中使用的数据类型是java.sql包下的类，
     * 但此时如果要使用java.util包中的时间日期类型，
     * 则需要而外标注@Temporal注释来说明转化成java.util包中的类型。
     */
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private java.util.Date createDate;

    /**
     *cascade：CascadeType.PERSIST（级联新建）、
     *          CascadeType.REMOVE（级联删除）、
     *          CascadeType.REFRESH（级联刷新）、
     *          CascadeType.MERGE（级联更新）、
     *          CascadeType.ALL（选择全部）
     *
     * 1.一对一和多对一的@JoinColumn注解的都是在“主控方”，都是本表指向外表的外键名称。
     * 2.一对多的@JoinColumn注解在“被控方”，即一的一方，指的是外表中指向本表的外键名称。
     * 3.多对多中，joinColumns写的都是本表在中间表的外键名称，
     *   inverseJoinColumns写的是另一个表在中间表的外键名称。
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "r_id")
    private Roles roles;

//    @Override
//    public String toString() {
//        return "Users{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
