package com.mjt.practice.meituan;

import java.util.Scanner;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/17 10:24
 * @Description
 *  小团一天最多可以烤n个蛋糕，每个蛋糕有一个正整数的重量。
 *  早上，糕点铺已经做好了m个蛋糕。
 *  现在，有一个顾客要来买两个蛋糕，他希望买这一天糕点铺烤好的最重的和最轻的蛋糕，并且希望这两个蛋糕的重量恰好为a和b。
 *  剩余的n-m个蛋糕可以现烤，请问小团能否满足他的要求？
 *
 *  input:
 *  每组数据的第一行包含4个整数，n,m,a,b，空格隔开。这里不保证a和b的大小关系。
 *  接下来一行m个数，空格隔开，代表烤好的蛋糕重量
 *  output:
 *  对于每一组数据，如果可以办到顾客的要求，输出YES，否则输出NO
 */
// example:
// input:
//4 2 2 4
//3 3
//4 2 2 4
//1 1
//4 2 2 4
//5 5
//4 2 4 2
//2 4
//2 2 2 4
//3 3
//3 2 2 4
//3 3
//3 2 2 4
//3 3
// output:
//YES
//NO
//NO
//YES
//NO
//NO
//NO
public class Baker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int a = 0;
        int b = 0;
        while (sc.hasNext()) {
            int confirmNum = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int temp = sc.nextInt();
                maxValue = Math.max(maxValue, temp);
                minValue = Math.min(minValue, temp);
            }
            int minA = Math.min(a, b);
            int maxB = Math.max(a, b);
            if (maxValue == maxB) {
                confirmNum++;
            }
            if (minValue == minA) {
                confirmNum++;
            }
            if (minValue < minA || maxValue > maxB) {
                System.out.println("NO");
                continue;
            }
            if (n - m + confirmNum >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
