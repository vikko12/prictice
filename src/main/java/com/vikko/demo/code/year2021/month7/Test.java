package com.vikko.demo.code.year2021.month7;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {  
        Queue<String> queue = new LinkedList<>();
        // 创建两个线程，让其不间断运行  
        Thread1 t1 = new Thread1(queue);
        Thread2 t2 = new Thread2(queue);
  
        t1.setName("线程一");  
        t2.setName("线程二");  
  
        t1.start();  
        t2.start();  
    }  
}  