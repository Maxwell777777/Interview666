package com.mjt.exam.tplink;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/24 15:34
 * @Description
 */
public class First {
    public static void main(String[] args) {
        int[] input = new int[]{2, -8, 3, 6};
        System.out.println(getRes(input));
    }
    private static int getRes(int[] array) {
        int len = array.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = array[0];
        dp2[0] = array[0];
        int res = array[0];
        for (int i = 1; i < len; i++) {
            dp1[i]=Math.max(array[i],Math.max(dp1[i-1]*array[i],dp2[i-1]*array[i]));
            dp2[i]=Math.min(array[i],Math.min(dp1[i-1]*array[i],dp2[i-1]*array[i]));
            res = Math.max(res, dp1[i]);
        }
        return res;
    }
}
