package com.mjt.algorithm.blockQueue;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/16 21:12
 * @Description
 */
public class MyBlockingQueue<T> {
    private int count;
    private int head;//从head取元素
    private int tail;//从tail添加元素
    private Object[] array;

    MyBlockingQueue(int size) {
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        array = new Object[size];
    }

    public synchronized T get() {
        while (count <= 0) {
            System.out.println("队列为空");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T res = (T) array[head];
        System.out.println("正在获取对象: " + res);
        count--;
        head = (head + 1) % array.length;
        notifyAll();
        return res;
    }

    public synchronized void put(T t) {
        while (count >= array.length) {
            System.out.println("队列已满");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在put对象: " + t);
        array[tail] = t;
        count++;
        tail = (tail + 1) % array.length;
        notifyAll();
    }
}
