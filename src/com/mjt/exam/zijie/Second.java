package com.mjt.exam.zijie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/12 10:33
 * @Description
 * 给定一棵二叉树，输入二叉树节点个数N，前序中序遍历结果
 * 输出判断这棵二叉树是否结构对称，如果对称输出最大值节点在树中对称节点的整数值，不对称请直接输出最大值节点的整数值
 */
/*
input:
3
1 3 4
3 1 4

output:
3

input:
5
1 3 5 7 2
5 3 1 2 7

output:
7

* */
public class Second {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            val = v;
        }
    }
    private static Map<Integer/* num */, Integer/* position */> map;
    private static boolean isSymmetrical;
    public static void main(String[] args) {
        map = new HashMap<>();
        isSymmetrical = true;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] preOrder = new int[N];
        int[] inOrder = new int[N];
        int maxValue = Integer.MIN_VALUE;
        int maxPos = 0;
        for (int i = 0; i < N; i++) {
            preOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            inOrder[i] = sc.nextInt();
            if (inOrder[i] > maxValue) {
                maxValue = inOrder[i];
                maxPos = i;
            }
        }
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        if (!isSymmetrical) {
            System.out.println(maxValue);
        } else {
            System.out.println(inOrder[inOrder.length - maxPos - 1]);
        }
    }
    private static void buildTree(int[] preOrder, int preS, int preE, int[] inOrder, int inS, int inE) {
        if (preS > preE) {
            return;
        }
        int position = map.get(preOrder[preS]);
        int leftNum = position - inS;
        if (leftNum != inE - position) {
            isSymmetrical = false;
            return;
        }
        buildTree(preOrder, preS + 1, preS + leftNum, inOrder, inS, position - 1);
        buildTree(preOrder, preS + leftNum + 1, preE, inOrder, position + 1, inE);
    }
}
