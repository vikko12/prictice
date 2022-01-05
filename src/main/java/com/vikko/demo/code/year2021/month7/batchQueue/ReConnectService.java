package com.vikko.demo.code.year2021.month7.batchQueue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReConnectService{
    private Lock lock = new ReentrantLock();
    private volatile ScheduledExecutorService executor;
    private ReconnectInterface reconnectInterface;
    private volatile ScheduledFuture<?> future;
    private long timeSecond;
    public ReConnectService(ReconnectInterface reconnectInterface,long timeSecond){
        executor = Executors.newScheduledThreadPool(1);
        this.reconnectInterface = reconnectInterface;
        this.timeSecond = timeSecond;

    }


    public void reconnect() {
        lock.lock();
        try {
            if(future!=null && future.isCancelled() == false) {
                return;
            }
            if(executor==null) {
                executor = Executors.newScheduledThreadPool(1);
            }
            future = executor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    if (reconnectInterface.re()) {
                        clear();
                    }
                }
            }, timeSecond, timeSecond, TimeUnit.SECONDS);
        } catch(Exception e) {
        }
        finally {
            lock.unlock();
        }
    }

    public void clear() {
        lock.lock();
        try {
            if(future!=null) {
                future.cancel(true);
                future = null;
            }
            if(executor!=null) {
                executor.shutdown();
                executor = null;
            }
        }
        catch(Exception e) {

        }
        finally {
            lock.unlock();
        }

    }


    public interface ReconnectInterface {
        public boolean  re();
    }

}