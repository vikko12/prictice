package com.vikko.demo.code.toolkit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: vikko
 * @Data: 2023/12/19 15:59
 * @Description:
 */
public class ArrayDequeTest {

    public static void main(String[] args){
        Deque<String> tokenList = new ArrayDeque<>();

        tokenList.offer("1");
        tokenList.offer("2");
        tokenList.offer("3");

        String peek = tokenList.peek();
        System.out.println(peek);

        String poll = tokenList.pollLast();
        System.out.println(poll);


    }
}
