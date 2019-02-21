package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertIntervalV2 {

    public static void main(String[] args) {
        InsertIntervalV2 insertIntervalV2=new InsertIntervalV2();
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(1,5));
        insertIntervalV2.insert(intervals,new Interval(2,3));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

//        intervals.add(newInterval);
//        Collections.sort(intervals, Comparator.comparingInt(item -> item.start));

        if(intervals==null||intervals.size()==0){
            intervals=new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).start>newInterval.start){
                intervals.add(i,newInterval);
                break;
            }else if(i==intervals.size()-1){
                intervals.add(newInterval);
                break;
            }
        }


        Interval pre=intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next=intervals.get(i);
            if(next.start<=pre.end){
                pre.end=Math.max(pre.end,next.end);
                intervals.remove(i);
                i--;
            }else {
                pre=intervals.get(i);
            }
        }
        return intervals;

    }
}
