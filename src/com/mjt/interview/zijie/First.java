package com.mjt.interview.zijie;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/8 10:10
 * @Description
 */
import java.util.*;

public class First {
    private static class Pos {
        int x;
        int y;
        Pos(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTest = sc.nextInt();
        while (numOfTest-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int[] ops = new int[N];
            for (int i = 0; i < N; i++) {
                ops[i] = sc.nextInt();
            }
            Pos[] positions = new Pos[M];
            for (int i = 0; i < M; i++) {
                int tx = sc.nextInt();
                int ty = sc.nextInt();
                positions[i] = new Pos(tx, ty);
            }
            move(ops);
        }

    }
    private static void move(int[] ops) {
        int len = ops.length;
        return;
    }
}
