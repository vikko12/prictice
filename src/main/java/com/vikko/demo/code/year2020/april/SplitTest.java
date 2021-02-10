package com.vikko.demo.code.year2020.april;

import javax.validation.constraints.NotNull;

public class SplitTest {
    public static void main(String[] args) {
//        String test = "testst_s";
//        String[] s = test.split("_");
//        System.out.println(s[s.length -1 ]);
        test(null,null);
    }
    public static void test(String a,@NotNull String b){
        System.out.println(a + b);
    }
}
