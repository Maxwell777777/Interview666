package com.mjt.algorithm.lfu;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/24 10:07
 * @Description
 */
public class LFUMain {
    public static void main(String[] args) {
        //treeSetLFUTest2();
        hashMapLFUTest();
    }
    private static void treeSetLFUTest() {
        HashMapLFU treeSetLFU = new HashMapLFU(2);
        treeSetLFU.put(1, 1);
        treeSetLFU.put(2, 2);
        System.out.println(treeSetLFU.get(1));//1
        treeSetLFU.put(3, 3);
        System.out.println(treeSetLFU.get(2));//-1
        System.out.println(treeSetLFU.get(3));//3
        treeSetLFU.put(4, 4);
        System.out.println(treeSetLFU.get(1));//-1
        System.out.println(treeSetLFU.get(3));//3
        System.out.println(treeSetLFU.get(4));//4
    }
    private static void treeSetLFUTest2() {
        HashMapLFU treeSetLFU = new HashMapLFU(2);
        treeSetLFU.put(3, 1);
        treeSetLFU.put(2, 1);
        treeSetLFU.put(2, 2);
        treeSetLFU.put(4, 4);
        System.out.println(treeSetLFU.get(2));//2
    }

    private static void hashMapLFUTest() {
        HashMapLFU hashMapLFU = new HashMapLFU(2);
        hashMapLFU.put(1, 1);
        hashMapLFU.put(2, 2);
        System.out.println(hashMapLFU.get(1));//1
        hashMapLFU.put(3, 3);
        System.out.println(hashMapLFU.get(2));//-1
        System.out.println(hashMapLFU.get(3));//3
        hashMapLFU.put(4, 4);
        System.out.println(hashMapLFU.get(1));//-1
        System.out.println(hashMapLFU.get(3));//3
        System.out.println(hashMapLFU.get(4));//4
    }
    private static void hashMapLFUTest2() {
        HashMapLFU hashMapLFU = new HashMapLFU(2);
        hashMapLFU.put(3, 1);
        hashMapLFU.put(2, 1);
        hashMapLFU.put(2, 2);
        hashMapLFU.put(4, 4);
        System.out.println(hashMapLFU.get(2));//2
    }
}
