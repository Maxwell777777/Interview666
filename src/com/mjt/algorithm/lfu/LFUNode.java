package com.mjt.algorithm.lfu;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/24 10:09
 * @Description
 */
public class LFUNode {
    private int freq;// 频率
    private int time;// 时间戳
    private int key;
    private int value;

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LFUNode(int freq, int time, int key, int value) {
        this.freq = freq;
        this.time = time;
        this.key = key;
        this.value = value;
    }
}
