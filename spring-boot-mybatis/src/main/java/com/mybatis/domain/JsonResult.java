package com.mybatis.domain;

import lombok.Data;

/**
 * @author BrokenColor
 * @data 2018年5月14日
 */
@Data
public class JsonResult {

	private String status = null;

	private Object result = null;

	public JsonResult status(String status) {
		this.status = status;
		return this;
	}
	
}
