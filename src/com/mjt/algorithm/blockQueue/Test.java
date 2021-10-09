package com.mjt.algorithm.blockQueue;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/16 21:15
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(3);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    queue.put(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    Integer res = queue.get();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
