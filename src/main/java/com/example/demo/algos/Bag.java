package com.example.demo.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 背包算法： 如何让背包中装下尽可以多的重量
 * 假设背包最大可承重20kg，现有3kg,4kg,5kg,6kg,8kg的东西
 */

public class Bag {
    /**
     * 结果集
     */
    private static Integer RESULT = 0;

    /**
     * 背包最大承载质量
     */
    private static Integer KNAPSACK_MAX_WEIGHT = 20;

    /**
     * @param selected
     * @param all
     */
    public static void bagAlgo(List<Integer> selected, List<Integer> all) {
        int sum = selected.stream().mapToInt(Integer::intValue).sum();
        if (sum == KNAPSACK_MAX_WEIGHT) {
            RESULT = KNAPSACK_MAX_WEIGHT;
            return;
        } else if (sum > KNAPSACK_MAX_WEIGHT) {  //超过大小了，最后一个拿掉
            selected.remove(selected.size() - 1);
            int weight = selected.stream().mapToInt(Integer::intValue).sum();
            RESULT = Math.max(RESULT, weight);
            return;
        } else {
            RESULT = Math.max(RESULT, sum);
        }

        for (Integer one : all) {
            if (selected.contains(one))
                continue;

            selected.add(one);
            bagAlgo(selected, all);
            selected.remove(one);
        }

    }

    public static void main(String[] args) {
        bagAlgo(new ArrayList<>(), Arrays.asList(3, 4, 6, 8));
        System.out.println("最大可装下：" + RESULT);
    }
}
