package com.mjt.algorithm.singleton;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/19 9:55
 * @Description
 */
public class HungrySingleton2 {
    private static HungrySingleton2 INSTANCE;
    static {
        INSTANCE = new HungrySingleton2();
    }
    private HungrySingleton2() {}
    public static HungrySingleton2 getInstance() {
        return INSTANCE;
    }
}
