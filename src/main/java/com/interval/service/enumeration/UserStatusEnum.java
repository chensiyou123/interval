package com.interval.service.enumeration;


/**
 * 是否枚举
 *
 * @author Mike
 */
public enum UserStatusEnum {
    NOTCHOOSE(0, "未选择课程"),
    ENABLE (1, "启用"),
    DISABLE (2, "禁用"),
    DELETED (3, "已被学校删除");


    private final Integer value;
    private final String name;

    private UserStatusEnum(Integer v, String desc) {
        this.value = v;
        this.name = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static UserStatusEnum get(Integer strValue) {
        for (UserStatusEnum e : values()) {
            if (e.getValue().equals(strValue)) {
                return e;
            }
        }
        return null;
    }
}
