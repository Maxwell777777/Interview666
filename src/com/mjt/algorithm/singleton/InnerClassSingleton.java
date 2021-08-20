package com.mjt.algorithm.singleton;

/**
 * @Author majuntian.mjt
 * @Date 2021/8/19 10:01
 * @Description
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {}
    private static class SingletonInstance {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
