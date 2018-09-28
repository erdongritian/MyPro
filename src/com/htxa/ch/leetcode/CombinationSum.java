package com.htxa.ch.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        int length=candidates.length;

        for (int i = 0; i < length; i++) {
            int sum=0;
            List<Integer> tempList=new ArrayList<>();
            int count=0;
            while (sum<target){
                count++;
                sum+=candidates[i];
                tempList.add(candidates[i]);
            }
            if(sum==target){
                List destList=new ArrayList();
                Collections.copy(destList,tempList);
                result.add(destList);
            }

            while (count>2){
                sum=sum-tempList.get(tempList.size()-1);
                tempList.remove(tempList.size()-1);

                sum=sum-tempList.get(tempList.size()-1);
                tempList.remove(tempList.size()-1);
                count--;

                int count2=0;
                while (sum<target){
                    count2++;
                    sum+=candidates[i+1];
                    tempList.add(candidates[i+1]);
                }
                if(sum==target){
                    List destList=new ArrayList();
                    Collections.copy(destList,tempList);
                    result.add(destList);
                }
            }
        }
        return result;
    }

    private void getList(List<List<Integer>> result,List<Integer> tempList){

//        while (count>2){
//            sum=sum-tempList.get(tempList.size()-1);
//            tempList.remove(tempList.size()-1);
//
//            sum=sum-tempList.get(tempList.size()-1);
//            tempList.remove(tempList.size()-1);
//            count--;
//
//            int count2=0;
//            while (sum<target){
//                count2++;
//                sum+=candidates[i+1];
//                tempList.add(candidates[i+1]);
//            }
//            if(sum==target){
//                List destList=new ArrayList();
//                Collections.copy(destList,tempList);
//                result.add(destList);
//            }
//        }


    }



}
