package com.mjt.algorithm.binarySearch;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/08/11/22:27
 * @Description:
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 5, 5, 6, 7};
        int[] nums2 = new int[]{7, 6, 5, 5, 3, 2, 1};
//        int findRes = binarySearch(nums1, 5);//3
//        int nonFindRes = binarySearch(nums1, 4);//-1
//        int findRes = reverseBinarySearch(nums2, 5);//3
//        int nonFindRes = reverseBinarySearch(nums2, 4);//-1

//        int findRes = leftBoundSearch(nums1, 5);//3
//        int nonFindRes = leftBoundSearch(nums1, 4);//-1
//        int findRes = reverseLeftBoundSearch(nums2, 5);//2
//        int nonFindRes = reverseLeftBoundSearch(nums2, 4);//-1

//        int findRes = rightBoundSearch(nums1, 5);//4
//        int nonFindRes = rightBoundSearch(nums1, 4);//-1
//        int findRes = reverseRightBoundSearch(nums2, 5);//3
//        int nonFindRes = reverseRightBoundSearch(nums2, 4);//-1

//        System.out.println("find position: " + findRes + " not find position: " + nonFindRes);

//        System.out.println(firstGreaterSearch(nums1, 5));//5
//        System.out.println(firstGreaterSearch(nums1, 3));//3
//        System.out.println(firstGreaterSearch(nums1, -2));//0
//        System.out.println(firstGreaterSearch(nums1, 8));//7
//        System.out.println("---------------");
//        System.out.println(firstLessSearch(nums1, 5));//2
//        System.out.println(firstLessSearch(nums1, 3));//1
//        System.out.println(firstLessSearch(nums1, -2));//-1
//        System.out.println(firstLessSearch(nums1, 8));//6
//        System.out.println(firstLessSearch(nums1, 1));//-1
    }
    // 标准二分查找，找不到返回-1
    private static int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    private static int reverseBinarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    // 查找左边界
    private static int leftBoundSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= len || nums[left] != target) {
            return -1;
        }
        return left;
    }
    private static int reverseLeftBoundSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= len || nums[left] != target) {
            return -1;
        }
        return left;
    }
    // 查找右边界
    private static int rightBoundSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
    private static int reverseRightBoundSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
    // 查找第一个大于target的位置
    private static int firstGreaterSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
    // 查找第一个小于target的位置
    private static int firstLessSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
