package com.mybatis.domain;

/**
 * @author BrokenColor
 * @data 2018年5月14日
 */
public class JsonResult {

	private String status = null;

	private Object result = null;

	public JsonResult status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	
}
