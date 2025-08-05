package com.seraphim.backend.util;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T> 响应主体
 * author: 魏子越
 * date: 2025/07/11
 */

@Data
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 业务代码
    private int code;

    // 返回信息
    private String msg;

    // 返回数据
    private T data;

    public static <T> R<T> success() { return restResult(100000, null, null); }
    public static <T> R<T> success(T data) { return restResult(100000, null, data); }
    public static <T> R<T> success(String msg) { return restResult(100000, msg, null); }
    public static <T> R<T> success(String msg, T data) { return restResult(100000, msg, data); }
    public static <T> R<T> failed() { return restResult(100900, null, null); }
    public static <T> R<T> failed(String msg) { return restResult(100000, msg, null); }
    public static <T> R<T> failed(String msg, T data) { return restResult(100000, msg, data); }
    public static <T> R<T> failed(T data) { return restResult(100900, null, data); }
    public static <T> R<T> failed(int code, String msg, T data) { return restResult(code, msg, data); }
    public static <T> R<T> failed(int code, String msg) { return restResult(code, msg, null); }
    public static <T> R<T> failed(int code, T data) { return restResult(code, null, data); }

    private static <T> R<T> restResult(int code, String msg, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
