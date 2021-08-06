package com.vikko.demo.algorithm.year2021.month4;

import com.vikko.demo.suanfa.year2021.month5.ReverseString2;

import java.util.Arrays;

/**
 * @see ReverseString2
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = " hello world vikko".toCharArray();
//        reverseString(chars);
        helper(chars, 0, chars.length - 1);

        int start = 0, end = 0;
        while ( end < chars.length){
            if(chars[end] == ' '){
                helper(chars,start,end-1);
                start = end + 1;
            }
            end++;
        }
        helper(chars,start,end -1);

        System.out.println(new String(chars));
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void helper(char[] s, int start, int end){
        int l = start, r = end;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void reverseString2(){

    }
}
