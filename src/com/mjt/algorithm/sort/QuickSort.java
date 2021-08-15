package com.mjt.algorithm.sort;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/13:15
 * @Description:
 */
public class QuickSort implements Sort{

    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        quickSort(0, len - 1);
    }

    private void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            while (array[++i] < array[mid]) {
                continue;
            }
            while (array[--j] > array[mid]) {
                continue;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        quickSort(left, j);
        quickSort(j + 1, right);
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
