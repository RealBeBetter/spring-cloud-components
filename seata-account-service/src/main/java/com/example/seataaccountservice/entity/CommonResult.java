package com.example.seataaccountservice.entity;

import lombok.Data;

/**
 * @author Real
 * @since 2023/6/4 0:06
 */
@Data
public class CommonResult<T> {

    private T data;
    private String message;
    private Integer code;

    public CommonResult() {
    }

    public CommonResult(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public CommonResult(String message, Integer code) {
        this(null, message, code);
    }

    public CommonResult(T data) {
        this(data, "操作成功", 200);
    }
}
