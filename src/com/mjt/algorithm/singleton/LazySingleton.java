package com.mjt.algorithm.singleton;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/19 9:58
 * @Description
 */
public class LazySingleton {
    private static volatile LazySingleton INSTANCE;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
