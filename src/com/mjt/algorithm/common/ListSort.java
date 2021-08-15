package com.mjt.algorithm.common;

import java.util.*;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/16:08
 * @Description:
 */
public class ListSort {
    public static void main(String[] args) {
//        PriorityQueue<User> priorityQueue = new PriorityQueue<>(
//            (o1, o2) -> {
//                int flag = o1.getAge() - o2.getAge();
//                if (flag == 0) {
//                    return o1.getName().compareTo(o2.getName());
//                }
//                return flag;
//            }
//        );
        User user1 = new User(1, "a");
        User user2 = new User(3, "b");
        User user3 = new User(2, "c");
        List<User> userList = Arrays.asList(user1, user2, user3);
//        Collections.sort(userList, new UserComparator());
        /**
         * 方法3
         */
//        Collections.sort(userList, (u1, u2) -> {
//            int flag = u1.getAge() - u2.getAge();
//            if (flag == 0) {
//                return u1.getName().compareTo(u2.getName());
//            }
//            return flag;
//        });
        /**
         * 方法4
         */
//        userList.sort((u1, u2) -> {
//            int flag = u1.getAge() - u2.getAge();
//            if (flag == 0) {
//                return u1.getName().compareTo(u2.getName());
//            }
//            return flag;
//        });
        /**
         * 方法5
         */
//        userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getName));
        /**
         * 方法6 逆序
         */
//        userList.sort(Comparator.comparing(
//            User::getAge, Comparator.reverseOrder()).thenComparing(User::getName));
        userList.sort(Comparator.comparing(
            User::getAge, (u1, u2) -> (u2 - u1)).thenComparing(User::getName));
        System.out.println(userList);
    }
}

/**
 * 方法1
 */
//class User implements Comparable<User>{
//    private int age;
//    private String name;
//
//    public User(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    @Override
//    public int compareTo(User o) {
//        return age - o.getAge();
//    }
//}



class User {
    private int age;
    private String name;
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


/**
 * 方法2
 */
//class UserComparator implements Comparator<User> {
//    @Override
//    public int compare(User o1, User o2) {
//        if (o1.getAge() > o2.getAge()) {
//            return 1;
//        } else if (o1.getAge() < o2.getAge()) {
//            return -1;
//        } else {
//            return o1.getName().compareTo(o2.getName());
//        }
//    }
//}
