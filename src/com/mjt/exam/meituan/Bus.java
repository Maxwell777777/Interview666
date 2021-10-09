package com.mjt.exam.meituan;

import java.util.*;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/4 15:42
 * @Description
 */
/*
input:
3 2
1 1
2 1 2
1 2

* */
public class Bus {
    private static List<Integer>[] graph;
    private static int times = 0;
    private static boolean[] used;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Set<Integer>[] input = new HashSet[n];
        for (int i = 0; i < n; i++) {
            input[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                input[i].add(sc.nextInt());
            }
        }
        buildGraph(input);
        //show(graph);
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                times = 0;
                Arrays.fill(used, false);
                used[i] = true;
                dfs(graph, i, j, times);
                res[i][j] = times;
                res[j][i] = times;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print(res[i][n - 1]);
            System.out.println();
        }
    }
    private static void show(List<Integer>[] graph) {
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            List<Integer> positions = graph[i];
            for (int position : positions) {
                System.out.print(position + " ");
            }
            System.out.println();
        }
    }
    private static void buildGraph(Set<Integer>[] input) {
        int len = input.length;
        for (int i = 0; i < len; i++) {
            Set<Integer> buses = input[i];
            for (int bus : buses) {
                for (int j = i + 1; j < len; j++) {
                    if (input[j].contains(bus)) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }
        }
    }
    private static void dfs(List<Integer>[] graph, int start, int end, int res) {
        if (start == end) {
            return;
        }
        List<Integer> positions = graph[start];
        for (int position : positions) {
            if (used[position]) {
                continue;
            }
            used[position] = true;
            dfs(graph, position, end, res++);
        }
    }
}
