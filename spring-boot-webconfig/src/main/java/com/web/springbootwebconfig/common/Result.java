package com.web.springbootwebconfig.common;

/**
 * @ClassName Result
 * @Description 用来封装服务器返回的数据信息
 * @Author Xujun
 * @Date 2019/8/20 16:55
 * @Version 1.0
 **/
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    private Long total;  //封装查询结果的总条数

    public Result() {
    }

    public Result(int code, String msg, T data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }
    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }
    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

//    @Override
//    public String toString() {
//        return JSON.toJSONString(this);
//    }

}
