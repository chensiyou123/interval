package com.interval.service.enumeration;


/**
 * 用户类型
 *
 * @author Mike
 */
public enum RoleTypeEnum {
    ADMIN(0, "系统管理员"),
    USER (1, "学校管理员");


    private final Integer value;
    private final String name;

    private RoleTypeEnum(Integer v, String desc) {
        this.value = v;
        this.name = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static RoleTypeEnum get(Integer strValue) {
        for (RoleTypeEnum e : values()) {
            if (e.getValue().equals(strValue)) {
                return e;
            }
        }
        return null;
    }
}
