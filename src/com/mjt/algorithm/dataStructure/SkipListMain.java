package com.mjt.algorithm.dataStructure;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/17 20:49
 * @Description
 */
public class SkipListMain {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(9);
        skipList.insert(4);
        skipList.display();
    }
}
