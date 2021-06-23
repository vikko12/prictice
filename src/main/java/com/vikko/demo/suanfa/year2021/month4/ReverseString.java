package com.vikko.demo.suanfa.year2021.month4;

import com.vikko.demo.suanfa.year2021.month5.ReverseString2;

import java.util.Arrays;

/**
 * @see ReverseString2
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = "hello world".toCharArray();
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void reverseString2(){

    }
}
