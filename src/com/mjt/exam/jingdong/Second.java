package com.mjt.exam.jingdong;

import java.util.*;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/11 20:02
 * @Description
 */
/*
input:
3 2
1 2
1 3
0
1 1
0 2

output:
3
1
* */
public class Second {
    private static Map<Integer, ArrayList<Integer>> startMap;
    private static Map<Integer, ArrayList<Integer>> closeMap;
    private static int[] startFlag;
    public static void main(String[] args) {
        startMap = new HashMap<>();
        closeMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        startFlag = new int[n];
        Arrays.fill(startFlag, 0);

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            for (int j = 1; j <= c; j++) {
                int depe_num = sc.nextInt();
                ArrayList<Integer> temp = startMap.getOrDefault(j, new ArrayList<>());
                temp.add(depe_num);
                startMap.put(j, temp);
                ArrayList<Integer> temp2 = closeMap.getOrDefault(depe_num, new ArrayList<>());
                temp2.add(j);
                closeMap.put(depe_num, temp2);
            }
        }

        for (int i = 0; i < q; i++) {
            int res = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 1) {
                ArrayList<Integer> startList = startMap.get(y);
                if (startFlag[y - 1] == 0) {
                    startFlag[y - 1] = 1;
                }
                for (int j = 0; j < startList.size(); j++) {
                    if (startFlag[startList.get(j) - 1] == 0) {
                        startFlag[startList.get(j) - 1] = 1;
                    }
                }
            } else {
                ArrayList<Integer> closeList = closeMap.get(y);
                if (startFlag[y - 1] == 1) {
                    startFlag[y - 1] = 0;
                }
                for (int j = 0; j < closeList.size(); j++) {
                    if (startFlag[closeList.get(j) - 1] == 1) {
                        startFlag[closeList.get(j) - 1] = 0;
                    }
                }
            }
            for (int t = 0; t < startFlag.length; t++) {
                res += startFlag[t];
            }
            System.out.println(res);
        }
    }
}
