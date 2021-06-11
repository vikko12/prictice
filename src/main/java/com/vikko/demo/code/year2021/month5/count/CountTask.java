package com.vikko.demo.code.year2021.month5.count;

import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {
    private int start;

    private int end;

    private int threshold;

    public CountTask(int start, int end, int threshold) {
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName());
        if (end - start <= threshold) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            int sum = 0;
            for (int i = start; i < end; ++i){
                sum += i;
            }
            return sum;
        } else {
            int median = (start + end) / 2;
            CountTask left = new CountTask(start, median, threshold);
            CountTask right = new CountTask(median, end, threshold);

            left.fork();
            right.fork();

            int leftValue = left.join();
            int rightValue = right.join();

            return leftValue + rightValue;
        }
    }
}
