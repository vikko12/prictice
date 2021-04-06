package com.vikko.demo.suanfa.year2021.month4;

public class IsSubSequence {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public boolean isSubsequence2(String s, String t) {
        int sl = s.length(), tl = t.length();
        int i = 0, j = 0;
        while (i < sl && j < tl){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        //最终判断i的索引是否与subString的length一样长
        return i == sl;
    }
}
