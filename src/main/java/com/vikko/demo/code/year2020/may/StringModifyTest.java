package com.vikko.demo.code.year2020.may;

/**
 * @author vikko
 * @date 2020/5/21 14:10
 */
public class StringModifyTest {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        String a = "aaaa";
        String b = a;
        b = b + "bb";
        System.out.println(a == b);
        System.out.println(a + "\n" + b);
    }
}
