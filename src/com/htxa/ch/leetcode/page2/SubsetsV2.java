package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

public class SubsetsV2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
