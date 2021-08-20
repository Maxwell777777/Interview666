package com.mjt.algorithm.List;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/18 16:29
 * @Description
 */
public class ListNode {
    private int value;
    private ListNode next = null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode(int value) {
        this.value = value;
    }
}
