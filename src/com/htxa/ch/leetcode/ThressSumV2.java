package com.htxa.ch.leetcode;

import java.util.*;

public class ThressSumV2 {
    public static void main(String[] args) {
        ThressSumV2 thressSum = new ThressSumV2();
//        List list=Arrays.asList(2,1);
//        List list2=Arrays.asList(2,1);
//        System.out.println(list.equals(list2));


//        Arrays.toString()
        System.out.println(Arrays.toString(thressSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toArray()));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int numsLength = nums.length;
        if(numsLength<3)
            return result;
        int zeroNum=0;
        List<Integer> negative=new ArrayList<>();
        List<Integer> positive=new ArrayList<>();
        Set<Integer> numSet=new HashSet<>();

        for (int i = 0; i < numsLength; i++) {
            if(nums[i]>0){
                positive.add(nums[i]);
                numSet.add(nums[i]);
            }else if(nums[i]<0){
                negative.add(nums[i]);
                numSet.add(nums[i]);
            }else{
                zeroNum++;
            }
        }

        if(positive.size()==0||negative.size()==0){
            if(zeroNum>2){
                result.add(Arrays.asList(0,0,0));
            }
            return result;
        }

        Collections.sort(positive);
        Collections.sort(negative);

//        System.out.println(Arrays.toString(positive.toArray()));
//        System.out.println(Arrays.toString(negative.toArray()));

         for (int i = 0; i < positive.size()-1; i++) {
            if(i>0&&positive.get(i).intValue()==positive.get(i-1).intValue()){
                continue ;
            }
            for (int j = i+1; j < positive.size(); j++) {
                if(j>i+1&&positive.get(j).intValue()==positive.get(j-1).intValue()){
                    continue ;
                }
                int sum=positive.get(i)+positive.get(j);
                if(sum>-negative.get(0)){
                    break;
                }
                if(numSet.contains(-sum)){
                    result.add(Arrays.asList(positive.get(i),positive.get(j),-sum));
                }
            }
        }

        for (int i = 0; i < negative.size()-1; i++) {
            if (i > 0 && negative.get(i).intValue() == negative.get(i - 1).intValue()) {
                continue;
            }
            for (int j = i + 1; j < negative.size(); j++) {
                if (j > i + 1 && negative.get(j).intValue() == negative.get(j - 1).intValue()) {
                    continue;
                }
                int sum = negative.get(i) + negative.get(j);
                if ( -sum < positive.get(0)) {
                    break;
                }
                if (numSet.contains(-sum)) {
                    result.add(Arrays.asList(negative.get(i), negative.get(j), -sum));
                }
            }
        }

//        int minSize=positive.size()> negative.size()?negative.size():positive.size();
        if(zeroNum>0){
            if(positive.size()>negative.size()){
                for (int i = 0; i < negative.size(); i++) {
                    if (i > 0 && negative.get(i) == negative.get(i - 1)) {
                        continue;
                    }
                    if(numSet.contains(-negative.get(i))) {
                        result.add(Arrays.asList(negative.get(i), -negative.get(i), 0));
                    }
                }
            }else {
                for (int i = 0; i < positive.size(); i++) {
                    if (i > 0 && positive.get(i) == positive.get(i - 1)) {
                        continue;
                    }
                    if(numSet.contains(-positive.get(i))) {
                        result.add(Arrays.asList(positive.get(i), -positive.get(i), 0));
                    }
                }
            }
        }


        if(zeroNum>2){
            result.add(Arrays.asList(0,0,0));
        }

        return result;
    }
}
