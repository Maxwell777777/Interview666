package com.mjt.exam.huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/11 9:25
 * @Description
 */
public class Words {
    public static void main(String[] args) {
        String[] strs = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atachb";
        // chars的统计
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = chars.toCharArray();
        for (char c : charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (String str : strs) {
            Map<Character, Integer> temp = new HashMap<>();
            char[] strTemp = str.toCharArray();
            boolean flag = true;
            for (char t : strTemp) {
                // 如果map不存在，肯定不能拼成
                if (!map.containsKey(t)) {
                    flag = false;
                    break;
                }
                int curNum = temp.getOrDefault(t, 0) + 1;
                // 如果超出了也不能拼成
                if (curNum > map.get(t)) {
                    flag = false;
                    break;
                }
                temp.put(t, curNum);
            }
            // 满足条件的str
            if (flag) {
                res += str.length();
            }
        }
        System.out.println(res);
    }
}
