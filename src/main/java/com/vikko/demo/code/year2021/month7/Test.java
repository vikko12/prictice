package com.vikko.demo.code.year2021.month7;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {  
         test2();
    }

    private void testThread(){
        Queue<String> queue = new LinkedList<>();
        // 创建两个线程，让其不间断运行
        Thread1 t1 = new Thread1(queue);
        Thread2 t2 = new Thread2(queue);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }

    public static void test2(){
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(1, 2, 3);
        List<Integer> list3 = Lists.newArrayList(1, 2, 3);
        List<Integer> list4 = Lists.newArrayList(14, 2, 3);
        List<Integer> list5 = Lists.newArrayList(11, 2, 3);
        System.out.println(list1.equals(list2));
        List<List<Integer>> lists = Lists.newArrayList(list1, list2, list3, list4, list5);
        List<List<Integer>> collect = lists.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

    }
}  