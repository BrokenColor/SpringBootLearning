package com.demo.springbootjpa.pojo;


import lombok.Data;

import javax.persistence.*;

/**
 * @Author: GWL
 * @Description:
 * @Date: Create in 22:40 2019/5/3
 * 我们使用 @Data 注解就可以有下面几个注解的功能：@ToString、@Getter、@Setter、@EqualsAndHashCode、@NoArgsConstructor 。
 *
 */
@Entity
@Table(name="user")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_age")
    private Integer age;

}
