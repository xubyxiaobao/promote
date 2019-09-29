package com.system.promote.enums;

import com.system.promote.utils.CommonUtils;

public enum ReturnCode implements BaseEnum {

    SUCCESS(200, "访问成功"),
    ERROR(999, "失败"),

    ;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    ;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public static ReturnCode getEnum(Integer code){
        return CommonUtils.getEnum(code, ReturnCode.class);
    }

}
