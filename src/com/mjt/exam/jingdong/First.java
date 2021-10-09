package com.mjt.exam.jingdong;

import java.util.*;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/11 18:50
 * @Description 机器臂打印
 */
/*
input:
2 2 1 1 1
.E
:F
EE:F.:

output:
15

* */
public class First {
    static class Position {
        int x;//row
        int y;//col
        int dire;//0上 1右 2下 3左 4初始
        int cost;
        Position (int _x, int _y, int _dire, int _cost) {
            this.x = _x;
            this.y = _y;
            this.dire = _dire;
            this.cost = _cost;
        }
    }
    private static Position start;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int move = sc.nextInt();//移动耗时
        int change = sc.nextInt();//转向耗时
        int click = sc.nextInt();//敲击耗时
        char[][] map = new char[rows][cols];
        sc.nextLine();
        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int j = 0; j < cols; j++) {
                map[i][j] = chars[j];
            }
        }
        //showMap(map);
        String words = sc.nextLine();
        int res = countMinStep(map, words, move, change, click);
        System.out.println(res);
    }
    private static int countMinStep(char[][] map, String words, int move, int change, int click) {
        char[] chars = words.toCharArray();
        int res = 0;
        start = new Position(0, 0, 4, 0);
        for (int i = 0; i < chars.length; i++) {
            int temp = bfs(map, chars[i], move, change, click);
            res += temp;
        }
        return res;
    }
    private static int bfs(char[][] map, char target, int move, int change, int click) {
        int rows = map.length;
        int cols = map[0].length;
        //Deque<Position> queue = new LinkedList<>();
        PriorityQueue<Position> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        queue.add(start);
        int res = 0;
        int[] ax = new int[]{-1, 0, 1, 0};
        int[] ay = new int[]{0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            if (map[temp.x][temp.y] == target) {
                res += temp.cost;
                res += click;
                return res;
            }
            int pre = temp.dire;
            for (int i = 0; i < 4; i++) {
                if (i == 0 && pre == 2) {
                    queue.add(new Position(temp.x, temp.y, 0, change));
                    continue;
                }
                if (i == 1 && pre == 3) {
                    queue.add(new Position(temp.x, temp.y, 1, change));
                    continue;
                }
                if (i == 2 && pre == 0) {
                    queue.add(new Position(temp.x, temp.y, 2, change));
                    continue;
                }
                if (i == 3 && pre == 1) {
                    queue.add(new Position(temp.x, temp.y, 3, change));
                    continue;
                }
                int xt = temp.x + ax[i];
                int yt = temp.y + ay[i];
                if (!valid(map, xt, yt)) {
                    continue;
                }
                queue.add(new Position(xt, yt, i, move));
            }
        }
        return res;
    }
    private static boolean valid(char[][] map, int x, int y) {
        int rows = map.length;
        int cols = map[0].length;
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return true;
        }
        return false;
    }
    private static void showMap(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
