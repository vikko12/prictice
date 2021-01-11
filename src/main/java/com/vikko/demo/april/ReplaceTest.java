package com.vikko.demo.april;

import java.util.HashMap;

/**
 * @author vikko
 * @date 2020/5/6 16:13
 */
public class ReplaceTest {
    public static void main(String[] args) {
        String a = "aaaab";
        a.replace("a","c");
        System.out.println(a);
    }
    public static void test(String param){
        param.replace("a","b");
    }
}
