package com.vikko.demo.algorithm.year2021.month4;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigitsHome {

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(removeKdigits(s,1));
    }

    public static String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for(int i = 1; i <= k; i++){
            int index = 0;
            for (int j = 1; j < sb.length() && sb.charAt(j) >= sb.charAt(j - 1); j++) {
                     index = j;
            }
            sb.deleteCharAt(index);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String removeKdigits2(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                idx = j;
            }
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }

    public String removeKdigits3(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
