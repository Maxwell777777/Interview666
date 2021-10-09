package com.mjt.exam.tencent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/26 20:05
 * @Description
 * 小红拿到了n根石柱，每根石柱高度是ai
 * 小红准备从其中挑选2根石柱，满足其中一根的高度是另一根的平方
 * 如果不存在输出-1
 */
/*
input:
2
3 9

output:
3 9

input:
5
12 144 6 30 7

output:
12 144
* */
public class Rock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int maxNum = array[array.length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > Math.sqrt(maxNum)) {
                set.add(array[i]);
                continue;
            }
            if (set.contains(array[i] * array[i])) {
                System.out.println(array[i] + " " + array[i] * array[i]);
                return;
            }
            set.add(array[i]);
        }
        System.out.println(-1);
    }
}
