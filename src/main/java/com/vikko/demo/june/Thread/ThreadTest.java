package com.vikko.demo.june.Thread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * @author vikko
 * @date 2020/6/24 13:45
 */
public class ThreadTest {
    public static void main(String[] args) {
        TestCompletableFuture();
    }

    public static String TestCompletableFuture(){
        LocalDateTime start = LocalDateTime.now();
        System.out.println("start = "+start);
        while (true) {

            CompletableFuture.supplyAsync(() -> {
                System.out.println("开始了");
                try {
                    Thread.sleep(2000);
                    System.out.println("sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 2;
            })
                    .thenApply(i -> (i + 1))
                    .thenApply(i -> i * i)
                    .whenComplete((e, r) -> {
                        System.out.println("input = " + e);
                    });
        }
//        LocalDateTime end = LocalDateTime.now();
//        System.out.println("end = " + end);
//        return null;
    }
}
