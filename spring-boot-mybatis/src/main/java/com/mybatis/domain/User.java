package com.mybatis.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BrokenColor
 * @data 2018年5月11日
 */
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	long id ;
	String name ;
	int age ;
	Date time;

}
