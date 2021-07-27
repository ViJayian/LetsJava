package com.geekbang.learngenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * .
 *
 * @author wangwenjie
 * @date 2021-07-16
 */
public class MyDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //>> TODO 泛型没有继承关系 只能通过协变转换.
        aMethods(list);
    }

    //>> TODO 协变泛型 这里可以直接写 List<?>.
    static void aMethods(List<? extends Object> list){

    }

    //>> TODO 逆变.
    //>> TODO String 的父类
    static void bMethods(List<? super String> list){

    }
}
