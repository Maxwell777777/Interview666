package com.mjt.algorithm.sort;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/13:27
 * @Description:
 */
public class Main {
//    private static int[] array = {3, 4, 1, 9, 5, 10};
    private static int[] array = {10, 6, 4, 4, 5, 8, 3};

    public static void main(String[] args) {
        showArray();
//        Sort sortAlgorithm = new QuickSort(array);
//        Sort sortAlgorithm = new MergeSort(array);
        Sort sortAlgorithm = new HeapSort(array);
        sortAlgorithm.sort();
        showArray();
    }

    private static void showArray() {
        int len = array.length;
        if (len <= 0) {
            System.out.println("array is null");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
