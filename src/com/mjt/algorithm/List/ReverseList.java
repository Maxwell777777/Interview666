package com.mjt.algorithm.List;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/18 16:27
 * @Description
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        showList(listNode1);
//        ListNode res = reverseList(listNode1);
        ListNode res = reverseList2(listNode1);
        showList(res);
    }
    public static ListNode reverseList(ListNode node) {
        ListNode res = null;
        while (node != null) {
            ListNode temp = node.getNext();
            node.setNext(res);
            res = node;
            node = temp;
        }
        return res;
    }
    public static ListNode reverseList2(ListNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        ListNode temp = reverseList2(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return temp;
    }
    private static void showList(ListNode node) {
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
