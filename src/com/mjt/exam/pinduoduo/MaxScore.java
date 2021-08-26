package com.mjt.exam.pinduoduo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/23 14:49
 * @Description
 */
/*
input:
7
1 1
2 2
3 3
4 4
5 4
6 4
2 6

output:
20

2
1 1
6 1

2
1 1
6 2

 */
public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] items = new int[num][2];
        int maxTime = 0;
        for (int i = 0; i < num; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
            maxTime = Math.max(maxTime, items[i][1]);
        }
        int res = countMaxScore(items, maxTime);
        System.out.println(res);
    }
    private static int countMaxScore(int[][] items, int maxTime) {
        int len = items.length;
        Arrays.sort(items, (o1, o2) -> {
            int flag = o2[1] - o1[1];
            if (flag == 0) {
                return o2[0] - o1[0];
            }
            return flag;
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int begin = 0;
        int res = 0;
        while (maxTime > 0) {
            while (begin < len && items[begin][1] >= maxTime) {
                queue.add(items[begin][0]);
                begin++;
            }
            if (!queue.isEmpty()) {
                res += queue.poll();
            }
            maxTime--;
        }
        return res;
    }
}
