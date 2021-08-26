package com.mjt.practice.huawei;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/25 19:06
 * @Description 在一张row*col的方格地图上，地图上每一个格子都有一个倒计时，时间为0无法通行
 * 可以上下左右四个方向运动，请设计一条路线，以最快的速度从起点到出口[0,0]->[row-1,col-1]
 */
/*
input:
5 5
3 5 4 2 3
4 5 3 4 3
4 3 5 3 2
2 5 3 3 5
5 3 4 4 3

output:
-1

input
3 3
2 3 2
5 1 1
4 5 5

output:
4

* */
public class Escape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //showMatrix(matrix);
        System.out.println(countEscapeSteps(matrix));
    }
    private static int countEscapeSteps(int[][] matrix) {
        int[] ax = new int[]{-1, 0, 1, 0};
        int[] ay = new int[]{0, 1, 0, -1};
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(used[i], false);
        }
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        used[0][0] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] temp = queue.pollFirst();
                if (temp[0] == row - 1 && temp[1] == col - 1) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    int xTemp = temp[0] + ax[j];
                    int yTemp = temp[1] + ay[j];
                    if (valid(xTemp, yTemp, matrix, time) && !used[xTemp][yTemp]) {
                        queue.addLast(new int[]{xTemp, yTemp});
                        used[xTemp][yTemp] = true;
                    }
                }
            }
            res++;
            time++;
        }
        return -1;
    }
    private static boolean valid(int x, int y, int[][] matrix, int time) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (x >= 0 && x < row && y >= 0 && y < col && matrix[x][y] > time) {
            return true;
        }
        return false;
    }
//    private static void showMatrix(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
