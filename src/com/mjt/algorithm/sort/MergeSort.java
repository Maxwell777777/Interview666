package com.mjt.algorithm.sort;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/13:37
 * @Description:
 */
public class MergeSort implements Sort{

    private int[] array;
    private int[] temp;

    public MergeSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        temp = new int[len];
        mergeSort(0, len - 1);
    }

    private void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        for (i = left, j = 0; i <= right; i++, j++) {
            array[i] = temp[j];
        }
    }
}
