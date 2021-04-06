package com.vikko.demo.suanfa.year2021.month4;

public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println(fib2(8));
    }

    public static int fib(int n){
        if(n<0){
            return -1;
        }
        if(n<= 1){
           return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fib2(int n){
        if(n<0){
            return -1;
        }
        if(n<= 1){
            return n;
        }
        int first = 0;
        int second = 1;
        int ret = 0;
        for(int i = 2; i <= n; i++) {
            //对题取模
            ret = first + second;
            if (ret >= 1000000007) {
                ret -= 1000000007;
            }
            first = second;
            second = ret;
        }
        return ret;
    }
}
