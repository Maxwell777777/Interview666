package com.mjt.algorithm.sort;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/15:14
 * @Description:
 */
public class HeapSort implements Sort{

    private int[] array;

    public HeapSort(int[] array) {
        this.array = array;
    }

    @Override
    public void sort() {
        heapSort();
    }

    private void heapSort() {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(0, i);
            adjustHeap(0, i);
        }
    }

    private void adjustHeap(int head, int length) {
        int temp = array[head];
        // left child
        int leftChild = 2 * head + 1;
        while (leftChild < length) {
            int rightChild = leftChild + 1;
            if (rightChild < length && array[rightChild] < array[leftChild]) {
                // 如果右孩子存在并且大于左孩子，用右孩子交换
                leftChild++;
            }
            // 这里注意，不能与head比较
            if (temp < array[leftChild]) {
                break;
            }
            array[head] = array[leftChild];

            head = leftChild;
            leftChild = 2 * leftChild + 1;
        }
        array[head] = temp;
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
