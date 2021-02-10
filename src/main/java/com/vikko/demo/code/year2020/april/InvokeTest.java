package com.vikko.demo.code.year2020.april;

import java.lang.reflect.Method;

/**
 * @author vikko
 * @date 2020/4/27 15:19
 */
public class InvokeTest {
    static Double aDouble = new Double(0.9);
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setColor("red");
        test(apple);
    }
    public static void test(Object object){
        String methodString = "getColor";
        String setMethodString = "setWeight";
        try {
            Method setMethod = object.getClass().getMethod(setMethodString, Double.class);
           setMethod.invoke(object, aDouble);
           Apple apple = (Apple)object;
            System.out.println(apple.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
