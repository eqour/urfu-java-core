package ru.eqour.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Task2357 {

    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                uniqueNums.add(num);
            }
        }
        return uniqueNums.size();
    }
}
