package com.mjt.exam.zijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/12 10:02
 * @Description
 * 编写一个多任务下载器，在做到计算任务并发数的时候遇到了困难
 * 在一次下载中，总共包含N个任务，每个任务会在第x秒开始，并持续y秒
 * 小M想知道，在一次下载中，同时最多会有多少个任务正在下载
 *
 * 第一行输入正整数N，代表任务数
 * 之后共N行，每行两个正整数xy，x代表任务开始时间，y代表任务的持续时间
 */
/*
input:
4
1 2
2 3
3 5
4 3

output:
3
* */
public class First {
    static class Time {
        int startTime;
        int endTime;
        Time(int s, int e) {
            startTime = s;
            endTime = e;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Time[] times = new Time[N];
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int tempStart = sc.nextInt();
            int tempEnd = tempStart + sc.nextInt() - 1;
            minTime = Math.min(minTime, tempStart);
            maxTime = Math.max(maxTime, tempEnd);
            times[i] = new Time(tempStart, tempEnd);
        }
        int[] missions = new int[maxTime - minTime + 1];
        for (Time t : times) {
            for (int i = t.startTime - minTime; i < t.endTime - minTime + 1; i++) {
                missions[i]++;
            }
        }
        Arrays.sort(missions);
        System.out.println(missions[missions.length - 1]);
    }
}
