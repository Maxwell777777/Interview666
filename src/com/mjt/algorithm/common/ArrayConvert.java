package com.mjt.algorithm.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: majuntian.mjt
 * @Date: 2021/07/17/12:43
 * @Description: 常用数组转换
 */
public class ArrayConvert {
    private static int[] array = {1, 2, 3};
    private static String[] stringArray = {"1", "2", "3"};
    public static void main(String[] args) {
        // int[] 转 List<Integer>
        List<Integer> integerList = Arrays.stream(array).boxed().collect(Collectors.toList());

        // int[] 转 Integer[]
        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);

        // List<Integer> 转 Integer[]
        Integer[] integers1 = integerList.toArray(new Integer[0]);

        // List<Integer> 转 int[]
        int[] array1 = integerList.stream().mapToInt(Integer::intValue).toArray();

        // Integer[] 转 int[]
        int[] array2 = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();

        // Integer[] 转 List<Integer>
        List<Integer> integerList1 = Arrays.asList(integers);

        // String[] 转 List<String>
        List<String> stringList = Arrays.asList(stringArray);

        // List<String> 转 String[]
        String[] strings = stringList.toArray(new String[0]);
    }
}
