package com.htxa.ch.leetcode.page1;

public class MedianOfTwoSortedArraysV2 {

    public static void main(String[] args) {
        MedianOfTwoSortedArraysV2 sortedArrays = new MedianOfTwoSortedArraysV2();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        System.out.println(sortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        if(num1Length<num2Length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int maxLenght = num1Length + num2Length;
        double result=0;
        int k=(maxLenght-1)>>1; //需要查找的指针位置

        int j=0;   //二分查找结果指针

        int low=0; //nums1的低位指针
        int high=num1Length-1; //nums1的高位指针

        //在长数组里查询短数组
        for(int i=0;i<num2Length;i++){

            low=binarySearch(nums1,nums2[i],low,high);
            if (maxLenght%2!=0&&low>k){
//                return
            }
            j=low;

        }

        if(maxLenght%2==0){

        }

        return result;
    }

    private int binarySearch(int[] nums,int target,int low,int high){

        while (low<=high){
            int mid=low+((high-low)>>1);
            if(target>nums[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return low;
    }


}
