package com.vikko.demo.june.Thread;

import java.text.SimpleDateFormat;

/**
 * @author vikko
 * @date 2020/6/24 14:44
 */
public class MyRunnable implements Runnable {
    private final ThreadLocal threadLocal = new ThreadLocal<String>();

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy HH:mm:ss");
            threadLocal.set(sdf);
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
}
