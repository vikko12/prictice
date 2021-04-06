package com.vikko.demo.suanfa.year2021.month4;

public class IsMonotonic {

    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] A) {
        boolean inc = A[A.length-1] - A[0] > 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i-1] && !inc || A[i] < A[i-1] && inc) return false;
        }
        return true;
    }

}
