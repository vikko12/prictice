package com.vikko.demo.code.year2021.month9.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CycleBarrierTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 将线程A添加到线程池
        executorService.submit(() -> {
            try {
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第1步。");
                cyclicBarrier.await();
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第2步。");
                cyclicBarrier.await();
                System.out.println("线程A：" + Thread.currentThread().getName() + "执行第3步。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 将线程B添加到线程池
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第1步。");
                cyclicBarrier.await();
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第2步。");
                cyclicBarrier.await();
                System.out.println("线程B：" + Thread.currentThread().getName() + "执行第3步。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 关闭线程池
        executorService.shutdown();
    }
}
