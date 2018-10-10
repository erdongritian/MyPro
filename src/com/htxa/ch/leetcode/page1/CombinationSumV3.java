package com.htxa.ch.leetcode.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumV3 {

    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        int target=7;
//        int[] candidates=new int[]{2,3,5};
//        int target=8;

        CombinationSumV3 combinationSum=new CombinationSumV3();
        System.out.println(combinationSum.combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        getSumValue(candidates.length-1,target,new ArrayList<>(),result,candidates);
        return result;
    }

    private void getSumValue(int currentIndex,int preValue,List<Integer> list,List<List<Integer>> resultList,int[] candidates){

        for (int i = currentIndex; i >-1; i--) {
            int currentValue=candidates[i];
            int tagValue=preValue-currentValue;
            if(tagValue==0){
                list.add(currentValue);
                resultList.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }else if(tagValue>0){
                list.add(currentValue);
                getSumValue(i,tagValue,list,resultList,candidates);
                list.remove(list.size()-1);
            }
        }
    }

}
