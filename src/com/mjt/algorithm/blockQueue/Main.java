package com.mjt.algorithm.blockQueue;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/16 22:00
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        MyArrayBlockingQueue<Integer> queue = new MyArrayBlockingQueue<>(3);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.get();
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
