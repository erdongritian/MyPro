package com.htxa.ch.leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if(target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static int searchInsertV2(int[] nums, int target) {
        int index=nums.length/2;

        if(nums.length==1){
            if(target<=nums[0]){
                return 0;
            }else {
                return 1;
            }
        }

        //复制数组可以优化
        if(target<=nums[index-1]){
            int[] newNums=Arrays.copyOf(nums,index);
            return searchInsertV2(newNums,target);
        }else if(target>nums[index]){
            int[] newNums=Arrays.copyOfRange(nums,index,nums.length);
            return index+searchInsertV2(newNums,target);
        }else {
            return index;
        }

    }

    public static int searchInsertV3(int[] nums, int target) {
        int index=(nums.length+1)/2;
        int tmp=index;
        while (true){
            if(index==0){
                if(target<=nums[index]){
                    return index;
                }else {
                    return 1+index;
                }
            }

            if(target<=nums[index-1]){
                tmp=(tmp/2)==0?1:(tmp/2);
                index=index-tmp;
            }else if(target>nums[index]){
                tmp=(tmp/2)==0?1:(tmp/2);
                index=index+tmp;
                if(index==nums.length){
                    return index;
                }
            }else {
                return index;
            }
        }
    }

    public static int searchInsertV4(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int median = low + ( (high - low) >> 1 );
            if (nums[median] < target) { low = median + 1; }
            if (nums[median] > target) { high = median - 1; }
            if (nums[median] == target) { return median; }
        }
        return low;
    }

    //有重复元素的数组
    public int searchInsertV5(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + ( (high - low) >> 1 );
            if (nums[mid] < target) { low = mid + 1; }
            if (nums[mid] >= target) { high = mid - 1; }
        }
        return low;
    }

    public static void main(String[] args) {
//        System.out.println(9>>1);
        int[] nums={1,3,5,6};
        System.out.println(searchInsertV4(nums,2));

//        int[] nums={1,3};
//        System.out.println(searchInsertV3(nums,4));
    }
}
