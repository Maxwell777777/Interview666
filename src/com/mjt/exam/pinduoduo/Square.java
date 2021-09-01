package com.mjt.exam.pinduoduo;

import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/31 19:03
 * @Description
 * 多多最近买了n条长度为1的木棍，他尝试着把木棍摆放在平面上，木棍能组成若干个1*1的正方形，多多想知道他最多能组成多少个1*1的正方形
 */
/*
input:
测试个数，木棍数量
2
4
5

output:
1
1

input:
1
10

output:
3

input:
1
22

output:
8
* */
public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTest = sc.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            int num = sc.nextInt();
            System.out.println(getNumOfSquare(num));
        }
    }
    private static int getNumOfSquare(int num) {
        return 0;
    }
}
