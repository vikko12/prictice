package com.vikko.demo.algorithm.year2021.month9;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    static List<String> res = new ArrayList<>();

    public static String[] permutation(String s) {
        if(s == null || s.length() == 0){
            return new String[0];
        }
        boolean[] visit = new boolean[s.length()];
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        backTrace(chars, sb, visit);
        return res.toArray(new String[0]);
    }
    private static void backTrace(char[] chars, StringBuilder sb, boolean[] visit){
        if(sb.length() == chars.length){
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i< chars.length; i++){
            if(visit[i]){
                continue;
            }
            sb.append(chars[i]);
            visit[i] = true;
            backTrace(chars, sb, visit);
            sb.deleteCharAt(sb.length()-1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}
