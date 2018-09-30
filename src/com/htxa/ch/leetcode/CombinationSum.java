package com.htxa.ch.leetcode;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        int target=7;
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates,target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();

        int length=candidates.length;
        for (int i = length-1; i >-1; i--) {
            LinkedList<Integer> list=new LinkedList();
            getSumValue(i,target,list,result,candidates);
        }

        return result;
    }

    private void getSumValue(int currentIndex,int preValue,LinkedList<Integer> list,List<List<Integer>> resultList,int[] candidates){
        int currentValue=candidates[currentIndex];
        int tagValue=preValue-currentValue;
        list.push(currentValue);
        if(tagValue==0){
            resultList.add(new ArrayList<>(list));
        }else if(tagValue>0){
            for (int i = currentIndex; i >-1 ; i--) {
                getSumValue(i,tagValue,list,resultList,candidates);
                list.pop();
            }
        }
    }
}
