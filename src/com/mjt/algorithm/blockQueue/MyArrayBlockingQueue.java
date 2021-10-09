package com.mjt.algorithm.blockQueue;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/16 21:53
 * @Description 自己实现
 */
public class MyArrayBlockingQueue<T> {
    private int count;
    private int head;// 从头部取元素
    private int tail;// 从尾部添加元素
    private Object[] array;

    MyArrayBlockingQueue (int size) {
        this.array = new Object[size];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 获取
     * @return
     */
    public synchronized T get() {
        while (count <= 0) {
            System.out.println("队列已空");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T res = (T)array[head];
        System.out.println("获取元素: " + res);
        head = (head + 1) % array.length;
        count--;
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
        System.out.println("正在添加: " + t);
        array[tail] = t;
        tail = (tail + 1) % array.length;
        count++;
        notifyAll();
    }
}
