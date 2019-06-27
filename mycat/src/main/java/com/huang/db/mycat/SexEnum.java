package com.huang.db.mycat;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author andyFan
 * @since 2019年03月10日
 */
public enum SexEnum {
    man(1), woman(0);

    private int code;

    SexEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static SexEnum getInstance(int code) {

        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getCode() == code) {
                return sexEnum;
            }
        }
        return null;
    }


}
