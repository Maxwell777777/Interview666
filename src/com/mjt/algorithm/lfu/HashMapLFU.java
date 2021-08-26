package com.mjt.algorithm.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/24 12:39
 * @Description 超时
 */
public class HashMapLFU {
    private int minFreq;
    private int size;
    Map<Integer/** key **/, LFUNode/** node **/> keyMap;
    Map<Integer/** freq **/, LinkedList<LFUNode>/** nodeList **/> freqMap;

    public HashMapLFU(int capacity) {
        this.size = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        if (keyMap.containsKey(key)) {
            // 存在
            LFUNode node = keyMap.get(key);
            delNode(node);
            addNode(node, node.getFreq() + 1);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            // 存在，需要覆盖
            LFUNode node = keyMap.get(key);
            delNode(node);
            node.setValue(value);
            addNode(node, node.getFreq() + 1);
            return;
        }
        if (keyMap.size() == size) {
            LFUNode temp = freqMap.get(minFreq).peekLast();
            keyMap.remove(temp.getKey());
            delNode(temp);
        }
        LFUNode node = new LFUNode(1, 0, key, value);
        addNode(node, 1);
        minFreq = 1;
    }

    // 删除节点，删除该freq对应的list中的节点
    private void delNode(LFUNode node) {
        freqMap.get(node.getFreq()).remove(node);
        if (freqMap.get(node.getFreq()).size() == 0) {
            freqMap.remove(node.getFreq());
            if (minFreq == node.getFreq()) {
                minFreq++;
            }
        }
    }

    // 添加节点，添加到freq List中
    private void addNode(LFUNode node, int freq) {
        LinkedList<LFUNode> list = freqMap.getOrDefault(freq, new LinkedList<>());
        list.addFirst(new LFUNode(freq, 0, node.getKey(), node.getValue()));
        freqMap.put(freq, list);
        keyMap.put(node.getKey(), freqMap.get(freq).peekFirst());
    }
}
