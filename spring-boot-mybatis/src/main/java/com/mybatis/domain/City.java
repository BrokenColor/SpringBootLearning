package com.mybatis.domain;

import lombok.Data;

/**
 * @author BrokenColor
 * @data 2018年5月24日
 */
@Data
public class City {

	 /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

}
