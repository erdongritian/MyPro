package com.htxa.ch.leetcode.page1;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        System.out.println(sortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        double result;

        int[] sortedArray;
        if (num1Length > num2Length) {
            sortedArray = getMergeArray(nums1, nums2);
        } else {
            sortedArray = getMergeArray(nums2, nums1);
        }

        int midIndex = (sortedArray.length - 1) >> 1;
        if (sortedArray.length % 2 == 0) {
            result = (double) (sortedArray[midIndex] + sortedArray[midIndex + 1]) / 2;
        } else {
            result = sortedArray[midIndex];
        }

        return result;
    }

    /**
     * 合并数组
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] getMergeArray(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int maxLenght = num1Length + num2Length;

        int[] sortedArray = new int[maxLenght];

        int low = 0;
        int high = num1Length - 1;
        int j = 0;  //sortedArray数组的指针
        int k = 0;  //nums1数组的指针
        //在nums1中插入nums2
        for (int i = 0; i < num2Length; i++) {
            if (low <= high) {
                low = search(nums1, nums2[i], low, high);
                //把nums1数组中low之前的数据拷贝到新数组中
                for (; k < low; k++) {
                    sortedArray[j] = nums1[k];
                    j++;
                }
                sortedArray[j] = nums2[i];
                j++;
            }
        }
        //把nums1剩余的数据插入新数组中
        for (; k < num1Length; k++) {
            sortedArray[j] = nums1[k];
            j++;
        }

        return sortedArray;
    }


    /**
     * 二分查找
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int search(int[] nums, int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
