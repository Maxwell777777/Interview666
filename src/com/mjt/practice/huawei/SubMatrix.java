package com.mjt.practice.huawei;

import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/25 19:02
 * @Description 二维矩阵选出最大和子矩阵
 */
/*
input:
3 4
-3 5 -1 5
2 4 -2 4
-1 3 -1 3

output:
20
* */
public class SubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j  =0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(countMax2d(matrix));
    }
    private static int countMax2d(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            int[] sumArray = new int[cols];
            for (int j = i; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    sumArray[k] += matrix[j][k];
                }
                res = Math.max(res, countMax1d(sumArray));
            }
        }
        return res;
    }
    private static int countMax1d(int[] array) {
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
