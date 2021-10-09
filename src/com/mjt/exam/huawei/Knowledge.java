package com.mjt.exam.huawei;

import java.util.*;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/1 19:13
 * @Description
 * 知识图谱是一种结构化的语义网络，可以看成一种有向图，图中的点是概念或实例，图中的边是概念及其实例的相关关系
 * 现定义一种简单的知识图谱
 * 概念：包括父概念及其子概念，通过subClassOf关系关联，父子概念可以有多个层级
 * 实例：仅和概念之间通过instanceOf关系关联
 * 关系：以三元组的形式表示，三元组是一个以空格为成员间分隔符的字符串
 * student subClassOf person
 * apple instanceOf fruit
 * 给定一个知识图谱，请编写一个方法，可以根据一个概念查找其所有的实例
 * 如果一个概念有子概念，那么返回的结果需要包含其所有子概念的实例
 * 如果输入的概念没有实例，返回empty字符串
 */
/*
input:
1
apple instanceOf fruit
fruit

output:
apple

input:
3
student subClassOf person
Tom instanceOf student
Marry instanceOf person
person

output:
Marry Tom
* */
public class Knowledge {
    static class Node {
        int type;
        String name;
        Node (int _type, String _name) {
            type = _type;
            name = _name;
        }
    }
    private static Map<String, List<Node>> map;
    public static void main(String[] args) {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int numOfLine = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfLine; i++) {
            String[] temp = sc.nextLine().split(" ");
            buildMap(temp);
        }
        String name = sc.nextLine();
        bfs(name);
    }
    private static void bfs(String name) {
        Deque<String> queue = new LinkedList<>();
        queue.addLast(name);
        while (!queue.isEmpty()) {
            String temp = queue.pollLast();
            List<Node> nodes = map.get(temp);
            for (Node node : nodes) {
                if (node.type == 1) {
                    System.out.print(node.name + " ");
                } else {
                    queue.addLast(node.name);
                }
            }
        }
    }
    private static void buildMap(String[] strs) {
        String father = strs[2];
        Node son;
        if (strs[1].equals("subClassOf")) {
            son = new Node(0, strs[0]);
        } else {
            son = new Node(1, strs[0]);
        }
        List<Node> list = map.getOrDefault(father, new ArrayList<>());
        list.add(son);
        map.put(father, list);
    }
}
