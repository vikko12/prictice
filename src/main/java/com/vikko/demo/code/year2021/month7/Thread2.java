package com.vikko.demo.code.year2021.month7;

import java.util.LinkedList;
import java.util.Queue;

public class Thread2 extends Thread {
    private Queue<String> queue = new LinkedList<>();
    private static int j = 1;  
  
    public Thread2(Queue<String> queue) {  
        this.queue = queue;  
    }  
    @Override
    public synchronized void run() {
        while (true) {
            String str;
            while (!queue.isEmpty()) {
                int k = 10;// 每次提交数设置为10，可以根据需要修改
                while ((str = queue.poll()) != null) {

                    --k;
                    System.out.println(k + "\t" + str);
                    if (k == 0) {
                        break;
                    }
                }

                System.out.println("当前运行的线程是：" + Thread.currentThread().getName() + "\t 第" + j + "次提交！队列还剩元素数："
                        + queue.size());
                j++;
                try {
                    Thread.sleep(5000);// 每次提交以后休眠5秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}