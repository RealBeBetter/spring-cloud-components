package com.example.ribbonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wei.song
 * @since 2023/4/11 16:59
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {

    private T data;
    private String message;
    private Integer code;

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
