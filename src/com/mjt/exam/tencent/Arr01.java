package com.mjt.exam.tencent;

import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/5 20:53
 * @Description
 */
/*
input:
6
010101

output:
7

input:
20
11111000111011101100

output:
94
* */
public class Arr01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfArr = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        System.out.println(countMaxValue(input));
    }
    private static int countMaxValue(String input) {
        int numOfone = 0;
        char[] chars = input.toCharArray();
        int leftZeros = 0;
        int leftOnes = 0;
        int rightZeros = 0;
        int rightOnes = 0;
        for (int i = 0; i < chars.length; i++) {
            numOfone += (chars[i] - '0');
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] != chars[i - 1]) {
                break;
            } else {
                if (chars[i] == '0') {
                    leftZeros++;
                } else {
                    leftOnes++;
                }
            }
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i < chars.length - 1 && chars[i] != chars[i + 1]) {
                break;
            } else {
                if (chars[i] == '0') {
                    rightZeros++;
                } else {
                    rightOnes++;
                }
            }
        }
        if (numOfone > chars.length / 2) {
            return getValue(numOfone) + getValue(leftZeros) + getValue(rightZeros);
        } else {
            return getValue(chars.length - numOfone) + getValue(leftOnes) + getValue(rightOnes);
        }
    }
    private static int getValue(int n) {
        return (1 + n) * n / 2;
    }
}
