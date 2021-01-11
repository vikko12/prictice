package com.vikko.demo.june;

/**
 * @author vikko
 * @date 2020/6/22 17:52
 */
public class SwapTest {
    public static void main(String[] args) {
//        Integer a = 1000;
//        Integer b = 2000;
//        System.out.println("a == " + a +"\n" + "b == " + b);
//        swapValue(a,b);
//        System.out.println("a == " + a +"\n" + "b == " + b);

        Integer a = new Integer(1000000);
        Integer b = new Integer(1000000);
        System.out.println(a.hashCode() == b.hashCode());
    }

    public static void swapValue(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }
}
