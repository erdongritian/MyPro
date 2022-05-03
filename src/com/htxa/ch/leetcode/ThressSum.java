package com.htxa.ch.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThressSum {
    public static void main(String[] args) {
        ThressSum thressSum = new ThressSum();
//        List list=Arrays.asList(2,1);
//        List list2=Arrays.asList(2,1);
//        System.out.println(list.equals(list2));


//        Arrays.toString()
        System.out.println(Arrays.toString(thressSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int numsLength = nums.length;
        Set<String> strSet=new HashSet<>();
        for (int i = 0; i < numsLength - 2; i++) {
            for (int j = i + 1; j < numsLength - 1; j++) {
                for (int k = j + 1; k < numsLength; k++) {
                     if (nums[i] + nums[j] + nums[k] == 0) {
                         List list=Arrays.asList(nums[i], nums[j], nums[k]);
                         Collections.sort(list);
                         if(strSet.add(list.get(0)+"|"+list.get(1)+"|"+list.get(2))){
                             result.add(list);
                         }
                    }
                }
            }
        }
        return result;
    }
}
