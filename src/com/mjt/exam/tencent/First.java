package com.mjt.exam.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/5 19:40
 * @Description
 */
/*
input:
3
1 3 5
4 2 6

output:
0
* */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPets = sc.nextInt();
        int[] aPets = new int[numOfPets];//攻击力，因子
        int[] bPets = new int[numOfPets];
        for (int i = 0; i < numOfPets; i++) {
            aPets[i] = getCount(sc.nextInt());
        }
        //show(aPets);
        for (int i = 0; i < numOfPets; i++) {
            bPets[i] = getCount(sc.nextInt());
        }
        //show(bPets);
        System.out.println(getWinNum2(aPets, bPets));
    }
    private static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int x = array[left + (right - left) / 2];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            while (array[++i] > x) {
                continue;
            }
            while (array[--j] < x) {
                continue;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        quickSort(array, left, j);
        quickSort(array, j + 1, right);
    }
    private static int getWinNum2(int[] aPets, int[] bPets) {
        quickSort(aPets, 0, aPets.length - 1);
        quickSort(bPets, 0, bPets.length - 1);
        int len = aPets.length;
        int aStart = 0;
        int aEnd = len - 1;
        int bStart = 0;
        int bEnd = len - 1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (aPets[aStart] > bPets[bStart]) {
                res++;
                aStart++;
                bStart++;
            } else if (aPets[aStart] < bPets[bStart]) {
                aEnd--;
                bStart++;
            }
            else {
                if (aPets[aEnd] > bPets[bEnd]) {
                    res++;
                    aEnd--;
                    bEnd--;
                } else {
                    aEnd--;
                    bStart++;
                }
            }
        }
        return res;
    }
    private static int getWinNum(int[] aPets, int[] bPets) {
        int len = aPets.length;
        Arrays.sort(aPets);
        Arrays.sort(bPets);
        int res = 0;
        int begin = 0;
        for (int i = 0; i < len; i++) {//b
            for (int j = begin; j < len; j++) {//a
                if (aPets[j] > bPets[i]) {
                    begin = j + 1;
                    res++;
                }
            }
        }
        return res;
    }
    private static int getCount(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int mid = (int) Math.sqrt(n);
        for (int i = 1; i <= mid; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    res++;
                } else {
                    res += 2;
                }
            }
        }
        return res;
    }
}
