package com.vikko.demo.suanfa.year2021.month4;

import java.util.Arrays;

/**
 * leetcode 88
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] a = {2,6,9,12};
        int[] b = {1,8,11,15};
        System.out.println(Arrays.toString(merge(a,b)));
    }

    public static int[] merge(int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;
        int[] sort = new int[al + bl];
        int i = 0, j = 0, cur = 0;
        while (i < al && j < bl) {
            if (a[i] <= b[j]) {
                sort[cur++] = a[i++];
            } else {
                sort[cur++] = b[j++];
            }
        }
        while (i < al) {
            sort[cur++] = a[i++];
        }
        while (j < bl) {
            sort[cur++] = b[j++];
        }
        return sort;
    }
}
