package com.mjt.exam.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/12 15:46
 * @Description
 */
/*
input:
[ [1,2], [1,2], [1,2] ]

output:
2
* */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
//        input = input.replace(" ", "");
//        System.out.println(input);
        input = input.substring(1, input.length() - 1);
        input = input.trim();
        String[] strs = input.split(", ");
        int len = strs.length;
        int[][] intervals = new int[len][2];
        for (int i = 0; i < len; i++) {
            intervals[i][0] = Integer.parseInt(strs[i].charAt(1) + "");
            intervals[i][1] = Integer.parseInt(strs[i].charAt(3) + "");
        }
        System.out.println(count(intervals));
    }
    private static int count(int[][] intervals) {
        int len = intervals.length;
        if (len < 1) {
            return 0;
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[1] - o1[1]));
        int right = intervals[0][1];
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return len - res;
    }
}
