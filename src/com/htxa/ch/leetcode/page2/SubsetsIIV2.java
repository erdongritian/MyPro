package com.htxa.ch.leetcode.page2;

import java.util.*;

public class SubsetsIIV2 {

    public static void main(String[] args) {
        SubsetsIIV2 subsetsII=new SubsetsIIV2();
        int[] nums=new int[]{1,1,2,2};
        System.out.println(subsetsII.subsetsWithDup(nums));

    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, res, curr);
        return res;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> curr){
        res.add(new ArrayList<>(curr));
        if(index == nums.length){
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(visited.add(nums[i])){
                curr.add(nums[i]);
                dfs(nums, i + 1, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
