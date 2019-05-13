package com.ehcache.springbootehcache.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: GWL
 * @Description: city表
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
@Table(name="t_city")
@Data
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @Column(name = "city_name")
    private String name;

    @Column(name = "city_description")
    private String description;

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


}
