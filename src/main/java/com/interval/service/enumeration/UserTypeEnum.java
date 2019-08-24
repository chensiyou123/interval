package com.interval.service.enumeration;


/**
 * 用户类型
 *
 * @author Mike
 */
public enum UserTypeEnum {
    ADMIN(0, "管理员"),
    USER (1, "普通用户");


    private final Integer value;
    private final String name;

    private UserTypeEnum(Integer v, String desc) {
        this.value = v;
        this.name = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static UserTypeEnum get(Integer strValue) {
        for (UserTypeEnum e : values()) {
            if (e.getValue().equals(strValue)) {
                return e;
            }
        }
        return null;
    }
}
