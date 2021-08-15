package com.mjt.algorithm.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/18:28
 * @Description:
 */
public class Swap {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4});
        showList(list);
        System.out.println("==============");
        swap(list, 0, 1);
        showList(list);
    }
    private static void showList(List<int[]> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j]);
            }
            System.out.println();
        }
    }
    public static void swap(List<int[]> list, int i, int j) {
        int[] temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
