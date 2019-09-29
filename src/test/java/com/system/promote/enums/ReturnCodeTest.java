package com.system.promote.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReturnCodeTest {


    @Test
    public void getEnumTest(){
        ReturnCode anEnum = ReturnCode.getEnum(200);
        System.out.println("OK");
    }
}