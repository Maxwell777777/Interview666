package com.mjt.exam.huawei;

/**
 * @Author majuntian.mjt
 * @Date 2021/9/1 19:04
 * @Description
 * 地图上有多个湖泊，为增强湖泊的抗暴雨能力，需要在湖泊间挖出通道，使得湖泊之间能够联通（对角线视为不连通）
 * 有的陆地是坚硬的石头，挖通需要耗费的精力是普通陆地的两倍，
 * 一个普通格子的长度为1，一个有坚硬石头的格子的长度为2
 * 地图用二维矩阵表示，各个位置三种可能，0为湖泊，1为普通陆地，2为坚硬的石头，地图最大为M*N
 * 需要返回挖通所有湖泊的最短通道，如果通道不存在返回0
 */
/*
第一行为M
第二行为N
第三行开始为地图矩阵
input:
5
4
0 1 1 0
0 1 0 0
0 1 0 0
0 1 0 1
1 1 1 1

output:
1

* */
public class Lake {
    private int a;
    Lake() {}
    Lake(Lake b) {
        this.a = b.a;
    }

    public static void main(String[] args) {
        Lake lake = new Lake();
        lake.a = 1;
        Lake lake1 = new Lake(lake);
    }
}
