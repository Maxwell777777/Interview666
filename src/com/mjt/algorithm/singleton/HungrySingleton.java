package com.mjt.algorithm.singleton;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/19 9:52
 * @Description
 */
public class HungrySingleton {
    private final static HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton () {}
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
