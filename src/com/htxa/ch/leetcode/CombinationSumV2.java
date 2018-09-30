package com.htxa.ch.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumV2 {

    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        int target=7;
//        int[] candidates=new int[]{2,3,5};
//        int target=8;

        CombinationSumV2 combinationSum=new CombinationSumV2();
        System.out.println(combinationSum.combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        getSumValue(candidates.length-1,target,new LinkedList(),result,candidates);
        return result;
    }

    private void getSumValue(int currentIndex,int preValue,LinkedList<Integer> list,List<List<Integer>> resultList,int[] candidates){

        for (int i = currentIndex; i >-1; i--) {
            int currentValue=candidates[i];
            int tagValue=preValue-currentValue;
            if(tagValue==0){
                list.push(currentValue);
                resultList.add(new ArrayList<>(list));
                list.pop();
            }else if(tagValue>0){
                list.push(currentValue);
                getSumValue(i,tagValue,list,resultList,candidates);
                list.pop();
            }
        }
    }

}
