package com.vikko.demo.code.year2021.month5;

class Consumer implements Runnable {

    private final MyQueen queen;

    /**
     * 该线程的名字
     */
    private final String name;

    /**
     * 需要消费的资料个数
     */
    private final int size;

    public Consumer(String name, MyQueen queen, int size) {
        this.name = name;
        this.queen = queen;
        this.size = size;
    }


    @Override
    public void run() {
        for (int i = 1; i <= size; i++) {
//            System.out.println(name + " consume start");
            int result = queen.dequeue();
//            System.out.println(name + " consume : " + result + " end");
        }
    }
}