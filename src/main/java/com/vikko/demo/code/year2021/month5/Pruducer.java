package com.vikko.demo.code.year2021.month5;

class Pruducer implements Runnable {

    private final MyQueen queen;

    /**
     * 该线程的名字
     */
    private final String name;

    /**
     * 开始的大小
     */
    private final int start;

    /**
     * 需要生产的资料个数
     */
    private final int size;

    public Pruducer(String name, MyQueen queen, int start, int size) {
        this.name = name;
        this.queen = queen;
        this.start = start;
        this.size = size;
    }


    @Override
    public void run() {
        for (int i = 1; i <= size; i++) {
            int now = start + i;
//            System.out.println(name + " produce : " + now + " start");
            queen.enter(now);
//            System.out.println(name + " produce : " + now + " end");
        }
    }
}