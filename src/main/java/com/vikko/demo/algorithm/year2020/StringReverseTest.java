package com.vikko.demo.algorithm.year2020;

/**
 * @author vikko
 * @date 2020/6/20 17:45
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String a = "I am a student";
        String wholeReverse = reverse(a);
        StringBuilder sb = new StringBuilder();
        char[] chars = wholeReverse.toCharArray();
        int last = 0;
        int now = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar == ' '){
                now = i;

            }
        }
    }

    public static String reverse(String input){
        char[] chars = input.toCharArray();
        int length = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = length -1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
