package com.mjt.algorithm.topK;

import com.mjt.algorithm.common.Swap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/18:37
 * @Description:
 */
public class QuickSortTopK {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        int[] nums2 = new int[]{5,-3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3};
//        int[] res1 = topKFrequent(nums1, 2);
//        showNums(res1);
        int[] res2 = topKFrequent(nums2, 3);
        showNums(res2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // valid
        int len = nums.length;
        if (k <= 0) {
            return new int[0];
        }
        int[] res = new int[k];
        if (len <= 0 || len < k) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // build frequency map
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<int[]> topKList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            topKList.add(new int[]{entry.getKey(), entry.getValue()});
//            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        // topK quickSort
        quickSort(topKList, 0, topKList.size() - 1, k);

        for (int i = 0; i < k; i++) {
            res[i] = topKList.get(i)[0];
        }
        return res;
    }
    private static void printList(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("(key: " + list.get(i)[0] + " freq: " + list.get(i)[1] + ")" + " ");
        }
        System.out.println();
    }
    private static void quickSort(List<int[]> list, int left, int right, int k) {
        printList(list);
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        int x = list.get(mid)[1];//注意，这里需要直接取到，不能在下面循环中计算，因为list在不断变化
        System.out.println("mid key: " + list.get(mid)[0] + " left: " + left + " right: " + right);
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            while (list.get(++i)[1] > x) {
                continue;
            }
            while (list.get(--j)[1] < x) {
                continue;
            }
            if (i < j) {
                Swap.swap(list, i, j);
            }
        }
        int sortedNum = j - left + 1;
        System.out.println("j= " + j + " sortedNum: " + sortedNum);
        if (sortedNum >= k) {
            quickSort(list, left, j, k);
        } else {
            quickSort(list, j + 1, right, k - sortedNum);
        }
    }
    private static void showNums(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
