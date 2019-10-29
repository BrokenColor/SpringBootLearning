package com.web.springbootwebconfig.common;

/**
 * @ClassName Result
 * @Description 用来封装服务器返回的数据信息
 * @Author Xujun
 * @Date 2019/8/20 16:55
 * @Version 1.0
 **/
public class Result {
    private int code;
    private String msg;
    private Object data;
    private Long total;  //封装查询结果的总条数

    public Result() {
    }

    public Result(int code, String msg, Object data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
