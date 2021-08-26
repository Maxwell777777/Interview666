package com.mjt.practice.zijie;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/24 21:53
 * @Description 找到最后一个负数和第一个正数，如果没有返回0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1, -4, 0, 0, 1, 5, 7, 3};
        //int[] nums = new int[]{-2, -1, -4, 1, 5, 7, 3};
        //int[] nums = new int[]{-2, -1, -4};
        int[] res = new int[2];// -4, 1
        int left = findLastNeg(nums);
        if (left == 0) {
            res[0] = 0;
        } else {
            res[0] = nums[left - 1];
        }
        int right = findFirstPos(nums);
        if (right == nums.length) {
            res[1] = 0;
        } else {
            res[1] = nums[right + 1];
        }
        System.out.println(res[0] + " " + res[1]);
    }
    private static int findLastNeg(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= len || nums[left] != 0) {
            return left;
        }
        return left;
    }
    private static int findFirstPos(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid - 1;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != 0) {
            return right;
        }
        return right;
    }
}
