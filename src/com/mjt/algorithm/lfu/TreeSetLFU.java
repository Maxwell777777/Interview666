package com.mjt.algorithm.lfu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/24 10:04
 * @Description
 */
public class TreeSetLFU {
    private int size;// 容量
    private int time;// 时间戳
    Map<Integer/* key */, LFUNode/* node */> map;
    TreeSet<LFUNode> treeSet;

    public TreeSetLFU(int capacity) {
        this.size = capacity;
        this.time = 0;
        map = new HashMap<>();
        treeSet = new TreeSet<>((o1, o2) -> {
            int flag = o1.getFreq() - o2.getFreq();
            if (flag == 0) {
                return o1.getTime() - o2.getTime();
            }
            return flag;
        });
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        if (map.containsKey(key)) {
            // 已经存在
            LFUNode node = map.get(key);
            treeSet.remove(node);
            node.setFreq(node.getFreq() + 1);
            node.setTime(++time);
            treeSet.add(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        if (map.containsKey(key)) {
            // 已经存在，覆盖
            LFUNode node = map.get(key);
            treeSet.remove(node);
            node.setFreq(node.getFreq() + 1);
            node.setTime(++time);
            node.setValue(value);
            treeSet.add(node);
            return;
        }
        if (map.size() == size) {
            map.remove(treeSet.first().getKey());
            treeSet.remove(treeSet.first());
        }
        LFUNode node = new LFUNode(1, ++time, key, value);
        map.put(key, node);
        treeSet.add(node);
    }

}
