package com.vikko.demo.suanfa.year2020.dp;

/**
 * @author vikko
 * @date 2020/6/23 17:24
 */
public class ReverseString {
    public static void main(String[] args) {
        String s = "I am a student";
        s = " " + s + " ";
        int len = s.length();
        int i = len-1;
        StringBuffer result = new StringBuffer();
        int end = len -1;
        int start = 0;
        while(i>= 0){
            if(s.charAt(i) == ' '){
                start = i;
                String subResult = s.substring(start, end);
                result.append(subResult);
                end = start;
            }
            i--;
        }
        System.out.println(result.toString().trim());
    }


    private static String reverseString(String stirng){
        int i = stirng.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (i >= 0){
            sb.append(stirng.charAt(i));
            i--;
        }
        return sb.toString();
    }
}
