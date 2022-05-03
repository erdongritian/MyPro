package com.htxa.ch.leetcode;

import java.util.Arrays;

public class ThreeSumClosestV2 {
    public static void main(String[] args) {
        ThreeSumClosestV2 threeSumClosest = new ThreeSumClosestV2();
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int tempTarget = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] - tempTarget < 0) {
                    if (Math.abs(nums[left] + nums[right] - tempTarget) < Math.abs(closest - target)) {
                        closest = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                } else if (nums[left] + nums[right] - tempTarget > 0) {
                    if (Math.abs(nums[left] + nums[right] - tempTarget) < Math.abs(closest - target)) {
                        closest = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
