package com.htxa.ch.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr=new int[]{4,7,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex=partition(arr,startIndex,endIndex);

        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    private static int partition(int[] arr,int startIndex,int endIndex){
        int pivot=arr[startIndex];
        int left=startIndex;
        int right=endIndex;

        while (left != right) {
            while (right > left && arr[right] > pivot) {
                right--;
            }

            while (right > left && arr[left] <= pivot) {
                left++;
            }

            if (right > left) {
                int t=arr[right];
                arr[right]=arr[left];
                arr[left]=t;
            }
        }

        int p=arr[left];
        arr[left]=arr[startIndex];
        arr[startIndex]=p;
        return left;
    }

}
