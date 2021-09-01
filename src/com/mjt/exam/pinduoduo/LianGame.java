package com.mjt.exam.pinduoduo;

import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/31 19:16
 * @Description
 * 连连看游戏，每局游戏一开始屏幕上会出现n个红色的方块和m个蓝色的方块，并且每个方块上都写有一个数字
 * 多多可以每次选取两个颜色不同且数字差异不超过k的方块将他们消除，然后得一分
 * 重复此操作，当无法进行任何匹配的时候这局游戏结束
 * 最多能获得多少分
 */

/*
input:
T组数据，红色方块数，蓝色方块数，最大数字差异
红色数字
蓝色数字
1
3 4 1
5 2 3
1 2 9 7

output:
2
* */
public class LianGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOdTes = sc.nextInt();
        for (int i = 0; i < numOdTes; i++) {
            int redNum = sc.nextInt();
            int blueNum = sc.nextInt();
        }
    }
}
