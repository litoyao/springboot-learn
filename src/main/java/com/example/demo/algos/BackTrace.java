package com.example.demo.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrace {

    /**
     * 数学中的排列组合算法
     *
     * @param selected
     * @param all
     */
    public static void permutation(List<Integer> selected, List<Integer> all) {
        if (selected.size() == all.size()) {
            System.out.println(Arrays.toString(selected.toArray()));
            return;
        }

        for (Integer one : all) {
            if (selected.contains(one))
                continue;

            selected.add(one);
            permutation(selected, all);
            selected.remove(one);
        }
    }


    public static void main(String[] args) {
        //找出1，2，3，4的所有排列组合
        List<Integer> items = Arrays.asList(1, 2, 3, 4);
        permutation(new ArrayList<>(), items);


    }
}
