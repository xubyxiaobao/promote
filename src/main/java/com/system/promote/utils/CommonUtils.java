package com.system.promote.utils;

import com.system.promote.enums.BaseEnum;

/**
 * @author xutao
 * created 2019/9/29 16:53
 */
public class CommonUtils {

    public static <T extends BaseEnum> T getEnum(Integer code, Class<T> clazz) {
        T[] enums = clazz.getEnumConstants();
        for (T anEnum : enums) {
            if (anEnum.getCode().equals(code)){
                return anEnum;
            }
        }
        return null;
    }



}
