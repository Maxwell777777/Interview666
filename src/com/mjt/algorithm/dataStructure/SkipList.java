package com.mjt.algorithm.dataStructure;

import java.util.Random;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/17 19:35
 * @Description 跳表Java实现
 */
public class SkipList {
    // 最大层级
    private static final int MAX_LEVEL = 16;
    // 索引层级
    private int levelCount = 1;
    // 头节点
    private Node head = new Node();
    private Random random = new Random();

    // 插入
    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        // 需要更新的节点
        Node[] update = new Node[level];
        // initialize
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }
        // 找到需要更新的节点的位置
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            update[i] = p;
        }
        // 更新
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if (levelCount < level) {
            levelCount = level;
        }
    }

    // 查找
    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
        }
        if (p.next[0] != null && p.next[0].data == value) {
            // 找到，返回原始链表中节点
            return p.next[0];
        } else {
            return null;
        }
    }

    // 删除
    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
            update[i] = p;
        }
        if (p.next[0] != null && p.next[0].data == value) {
            // 删除这个节点
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].data == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    // 显示跳表中的节点
    public void display() {
        Node p = head;
        while (p.next[0] != null) {
            System.out.println(p.next[0] + " ");
            p = p.next[0];
        }
        System.out.println();
    }

    /**
     * 生成随机level
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (random.nextBoolean()) {
            level++;
        }
        return Math.min(level, MAX_LEVEL);
    }

    // Node 内部类
    class Node {
        private int data = -1;
        private Node[] next = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append("}");
            return builder.toString();
        }
    }
}
