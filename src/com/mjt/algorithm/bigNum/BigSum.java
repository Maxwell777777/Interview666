package com.mjt.algorithm.bigNum;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/20 10:42
 * @Description
 */
public class BigSum {
    public static void main(String[] args) {
        String num1 = "129";
        String num2 = "989";
        System.out.println(solve(num1, num2));
    }
    private static String solve(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < 1 && tLen < 1) {
            return "0";
        }
        if (sLen < 1) {
            return t;
        }
        if (tLen < 1) {
            return s;
        }
        int i;
        int j;
        int c = 0;
        StringBuilder res = new StringBuilder();
        for (i = sLen - 1, j = tLen - 1; i >= 0 && j >= 0; i--, j--) {
            int temp = Integer.parseInt(s.charAt(i) + "") + Integer.parseInt(t.charAt(j) + "") + c;
            c = temp / 10;
            res.append(temp % 10);
        }
        while (i >= 0) {
            int temp = Integer.parseInt(s.charAt(i) + "") + c;
            c = temp / 10;
            res.append(temp % 10);
            i--;
        }
        while (j >= 0) {
            int temp = Integer.parseInt(t.charAt(j) + "") + c;
            c = temp / 10;
            res.append(temp % 10);
            j--;
        }
        if (c == 1) {
            res.append(c);
        }
        return res.reverse().toString();
    }
}
