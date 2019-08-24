package com.interval.service.enumeration;


/**
 * 是否枚举
 *
 * @author Mike
 */
public enum YesNoEnum {
    YES(1, "是"),
    NO(0, "否");

    private final Integer value;
    private final String name;

    private YesNoEnum(Integer v, String desc) {
        this.value = v;
        this.name = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static YesNoEnum get(Integer strValue) {
        for (YesNoEnum e : values()) {
            if (e.getValue().equals(strValue)) {
                return e;
            }
        }
        return null;
    }
}
