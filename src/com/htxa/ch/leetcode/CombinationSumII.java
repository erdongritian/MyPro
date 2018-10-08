package com.htxa.ch.leetcode;

import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
//        System.out.println(new ArrayList<>());
        int[] candidates=new int[]{10,1,2,7,6,1,5};
        int target=8;
        CombinationSumII combinationSum=new CombinationSumII();
        System.out.println(combinationSum.combinationSum2(candidates,target));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        Set<String> stringSet=new HashSet<>();
        getSumValue(candidates.length-1,target,new ArrayList<>(),result,candidates,stringSet);
        return result;
    }

    private void getSumValue(int currentIndex,int preValue,List<Integer> list,List<List<Integer>> resultList,int[] candidates,Set<String> stringSet){

        for (int i = currentIndex; i >-1; i--) {
            int currentValue=candidates[i];
            int tagValue=preValue-currentValue;
            if(tagValue==0){
                list.add(currentValue);
                if(stringSet.add(list.toString())){
                    resultList.add(new ArrayList<>(list));
                }
                list.remove(list.size()-1);
            }else if(tagValue>0){
                list.add(currentValue);
                getSumValue(i-1,tagValue,list,resultList,candidates,stringSet);
                list.remove(list.size()-1);
            }
        }
    }
}
