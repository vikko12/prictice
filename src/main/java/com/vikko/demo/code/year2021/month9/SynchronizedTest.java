package com.vikko.demo.code.year2021.month9;

import java.util.stream.IntStream;
import org.openjdk.jol.info.ClassLayout;

public class SynchronizedTest {
 
    static Object yesLock;
 
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000L);//偏向锁延迟4秒启动，此处等它5秒
        yesLock = new Object();
        System.out.println("无锁时对象布局：" + ClassLayout.parseInstance(yesLock).toPrintable());
        getLock("偏向锁");
        Thread.sleep(200L);
        getLock("轻量级锁");
        Thread.sleep(200L);
        IntStream.rangeClosed(1,2).forEach(i->{
            getLock("重量级锁");});
        Thread.sleep(2000L);
        System.out.println("无竞争之后，此时的对象布局：" + ClassLayout.parseInstance(yesLock).toPrintable());
        getLock("轻量级锁");//此时再来一次加锁
    }
 
 
    private static void getLock(final String expectLockLevel) {
        new Thread(() -> {
            try {
                synchronized (yesLock) {
                    System.out.println("线程[" + Thread.currentThread().getName() + "]" +
                            ":" + expectLockLevel + "状态对象布局:" + ClassLayout.parseInstance(yesLock).toPrintable());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
 
}