package com.htxa.ch.leetcode;

public class MaxAres {
    public static void main(String[] args) {
        MaxAres maxAres = new MaxAres();
//        int[] ares= new int[]{1,8,6,2,5,4,8,3,7};
        int[] ares = new int[]{4, 3, 2, 1, 4};
        System.out.println(maxAres.maxArea(ares));
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxValue = 0;
        while (rightIndex > leftIndex) {
            int tmpValue = 0;
            if (height[leftIndex] >= height[rightIndex]) {
                tmpValue = height[rightIndex] * (rightIndex - leftIndex);
            } else {
                tmpValue = height[leftIndex] * (rightIndex - leftIndex);
            }

            if (tmpValue > maxValue) {
                maxValue = tmpValue;
            }

            if ((rightIndex - leftIndex) == 1) {
                break;
            }

            if (height[leftIndex] > height[rightIndex]) {
                int rightTmp = height[rightIndex];
                rightIndex--;
                while (height[rightIndex] <= rightTmp && rightIndex > leftIndex) {
                    rightIndex--;
                }
            } else if (height[leftIndex] < height[rightIndex]) {
                int leftTmp = height[leftIndex];
                leftIndex++;
                while (height[leftIndex] <= leftTmp && rightIndex > leftIndex) {
                    leftIndex++;
                }
            } else {
                int rightTmp = height[rightIndex];
                rightIndex--;
                while (height[rightIndex] <= rightTmp && rightIndex > leftIndex) {
                    rightIndex--;
                }
                int leftTmp = height[leftIndex];
                leftIndex++;
                while (height[leftIndex] <= leftTmp && rightIndex > leftIndex) {
                    leftIndex++;
                }
            }
        }
        return maxValue;
    }
}
