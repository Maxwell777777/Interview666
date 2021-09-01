package com.mjt.exam.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/31 19:41
 * @Description
 * 特殊字符串：一个字符串S，长为Len，则该字符串下标index和Len-index-1位置上的字符串可以交换位置
 *
 * 定义两个这样的字符串AB的字典序大小关系
 * 只有当某一个形态的A的字典序小于B的所有形态时我们才说A小于B
 * 同样，某一个形态B小于所有的A，则B小于A
 * 否则A=B
 * 对N个这样的字符串，请排序
 */
/*
input:
2
dcba
abcd

output:
dcba
abcd

input:
2
abcde
abcdeaf

output:
abcdeaf
abcde
* */
public class MagicStr {
    static class Str {
        String origin;
        String minStr;
        Str(String _origin, String _minStr) {
            origin = _origin;
            minStr = _minStr;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfStr = sc.nextInt();
        String[] strs = new String[numOfStr];
        sc.nextLine();
        for (int i = 0; i < numOfStr; i++) {
            strs[i] = sc.nextLine();
            System.out.println(strs[i]);
        }
        Str[] sortStr = new Str[numOfStr];
        for (int i = 0; i < strs.length; i++) {
            String minStr = getMinStr(strs[i]);
            sortStr[i] = new Str(strs[i], minStr);
        }
        Arrays.sort(sortStr, (Comparator.comparing(o -> o.minStr)));
        for (int i = 0; i < numOfStr; i++) {
            System.out.println(sortStr[i].origin);
        }
    }
    private static String getMinStr(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] > chars[chars.length - i - 1]) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
        }
        return String.copyValueOf(chars);
    }
    private static void show(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
