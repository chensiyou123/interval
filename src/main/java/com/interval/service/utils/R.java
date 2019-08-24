package com.interval.service.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 成功处理，默认信息
     */
    public R() {
        put("code", 0);
        put("msg", "success");
    }

    /**
     * 成功处理，自定义信息
     * @param msg 提示信息
     * @return
     */
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    /**
     * 成功处理，自定义信息
     * @param map 自定义数据和信息
     * @return
     */
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    /**
     * 处理失败默认提示
     * @return
     */
    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    /**
     * 失败处理自定义信息
     * @param msg
     * @return
     */
    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 失败处理自定义错误编码和提示
     * @param code
     * @param msg
     * @return
     */
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }


}
