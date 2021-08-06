package com.vikko.demo.code.year2021.month7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Thread1 extends Thread {
    Queue<String> queue = new LinkedList<>();
    private static int m = 1;  
  
    public Thread1(Queue<String> queue) {  
        this.queue = queue;  
    }  
  
    @Override  
    public synchronized void run() {  
        while (true) {  
            Random rnd = new Random();
            // 每次随机生产10个一下个元素加入队列
            int len = rnd.nextInt(10);
  
            for (int i = 0; i < len; i++) {  
                queue.offer("element:" + (m++));  
            }  
            System.out.println("当前运行的线程是：" + Thread.currentThread().getName() + "\t 本次新加入元素数：" + len + "\t 队列中元素总数是："  
                    + queue.size());  
            try {  
                Thread.sleep(rnd.nextInt(5000));
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  