package com.vikko.demo.code.year2021.month5;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueen {

    // 共享变量（任何操作之前，都需要获得该锁才可以执行）
    private final Lock lock = new ReentrantLock();

    // 条件变量：队列不满
    private final Condition notFull = lock.newCondition();

    // 条件变量：队列不空
    private final Condition notEmpty = lock.newCondition();

    /**
     * 存储队列的容器
     */
    private final LinkedList<Integer> list = new LinkedList<>();

    /**
     * 最大容量
     */
    private int capacity;

    /**
     * 当前容器中存储的数量
     */
    private int size;

    public MyQueen(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 入队
     */
    public void enter(int value) {
        lock.lock();
        try {
            // 如果队列已满，则需要等到队列不满
            while (size >= capacity) {
                notFull.await(1, TimeUnit.MILLISECONDS);
            }

            // 入队
            list.add(value);
            size++;
            System.out.println(value + " has bean entered");
            // 通知可以出队
            notEmpty.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    /**
     * 出队
     */
    public int dequeue() {
        Integer result = null;
        lock.lock();
        try {
            // 如果队列已空，则需要等到队列不空
            while (size <= 0) {
                notEmpty.await(1, TimeUnit.MILLISECONDS);
            }

            // 出队
            result = list.removeFirst();
            size--;
            System.out.println(result + " has bean dequeued");
            // 通知可以入队
            notFull.signal();
            return result;
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
        return result;
    }

    public static void main(String[] args) {
        MyQueen myQueen = new MyQueen(3);
        new Thread(new Pruducer("producer1", myQueen, 0, 2)).start();
        new Thread(new Pruducer("producer2", myQueen, 2, 5)).start();
        new Thread(new Consumer("consumer2", myQueen, 5)).start();
        new Thread(new Consumer("consumer1", myQueen, 3)).start();
    }
}
