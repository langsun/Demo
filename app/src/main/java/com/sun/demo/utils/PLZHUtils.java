package com.sun.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sun on 18/9/12.
 */

public class PLZHUtils {
    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    /**
     * 排列计算公式A<sup>m</sup><sub>n</sub> = n!/(n - m)!
     *
     * @param m
     * @param n
     * @return
     */
    public static long arrangement(int m, int n) {
        return m <= n ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     *
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }


    /**
     * 排列选择（从列表中选择n个排列）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void arrangementSelect(String[] dataList, int n) {

        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, arrangement(n, dataList.length)));
        arrangementSelect(dataList, new String[n], 0);
    }

    /**
     * 排列选择
     *
     * @param dataList    待选列表
     * @param resultList  前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex + 1);
            }
        }
    }

    /**
     * 组合选择（从列表中选择n个组合）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d",
                dataList.length, n, combination(dataList.length, n)));
        combinationSelect(dataList, 0, new String[n], 0);
    }

    /**
     * 组合选择
     *
     * @param dataList    待选列表
     * @param dataIndex   待选开始索引
     * @param resultList  前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

    /**
     * 从n个数字中选择m个数字
     *
     * @param n
     * @param m
     * @return
     * @throws Exception
     */
    public static List<int[]> combine(int n, int m) {
        if (m > n) {
            return null;
        }
        List<int[]> result = new ArrayList<int[]>();
        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            bs[i] = 0;
        }
        // 初始化
        for (int i = 0; i < m; i++) {
            bs[i] = 1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;

        // 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
        do {
            sum = 0;
            pos = 0;
            tempFlag = true;
            result.add(copy(bs));
            if (n == m) {
                return result;
            } else if (m == 0) {
                return result;
            }
            for (int i = 0; i < n - 1; i++) {
                if (bs[i] == 1 && bs[i + 1] == 0) {
                    bs[i] = 0;
                    bs[i + 1] = 1;
                    pos = i;
                    break;
                }
            }
            // 将左边的1全部移动到数组的最左边
            for (int i = 0; i < pos; i++) {
                if (bs[i] == 1) {
                    sum++;
                }


            }
            for (int i = 0; i < pos; i++) {
                if (i < sum) {
                    bs[i] = 1;
                } else {
                    bs[i] = 0;
                }
            }
            // 检查是否所有的1都移动到了最右边
            for (int i = n - m; i < n; i++) {
                if (bs[i] == 0) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag == false) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        result.add(copy(bs));
        return result;
    }

    private static int[] copy(int[] bs) {
        int[] result = new int[bs.length];
        for (int i = 0; i < bs.length; i++) {
            result[i] = bs[i];
        }
        return result;
    }
}
