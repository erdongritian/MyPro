package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过，但速度较慢，常规算法，应该是先按start排序，然后在组合。
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals=new MergeIntervals();
        List<Interval> intervals=new ArrayList<>();
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));

//        intervals.add(new Interval(2,3));
//        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(1,10));
//        [[1,3],[0,2],[2,3],[4,6],[4,5],[5,5],[0,2],[3,3]]

//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(0,2));
//        intervals.add(new Interval(2,3));
//        intervals.add(new Interval(4,6));
//        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(5,5));
//        intervals.add(new Interval(0,2));
//        intervals.add(new Interval(3,3));

//[[0,0],[0,0],[4,4],[0,0],[1,3],[5,5],[4,6],[1,1],[0,2]]
//        intervals.add(new Interval(0,0));
//        intervals.add(new Interval(0,0));
//        intervals.add(new Interval(4,4));
//        intervals.add(new Interval(0,0));
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(5,5));
//        intervals.add(new Interval(4,6));
//        intervals.add(new Interval(1,1));
//        intervals.add(new Interval(0,2));
//[[3,5],[0,0],[4,4],[0,2],[5,6],[4,5],[3,5],[1,3],[4,6],[4,6],[3,4]]
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(0,0));
        intervals.add(new Interval(4,4));
        intervals.add(new Interval(0,2));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(4,5));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(4,6));
        intervals.add(new Interval(3,4));


        mergeIntervals.merge(intervals);
        System.out.println(mergeIntervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        Interval preInterval;
        Interval nextInterval;
        int[] removeArray=new int[intervals.size()];

        for (int i = 0; i < intervals.size()-1; i++) {
            if(removeArray[i]==-1){
                continue;
            }
            preInterval=intervals.get(i);
//[[3,5],[0,0],[4,4],[0,2],[5,6],[4,5],[3,5],[1,3],[4,6],[4,6],[3,4]]
            for (int j = 0; j < intervals.size(); j++) {
                if(i==j||removeArray[j]==-1){
                    continue;
                }
                nextInterval=intervals.get(j);
                if(nextInterval.start>preInterval.end||nextInterval.end<preInterval.start){
                    continue;
                }
                int[] point=new int[]{nextInterval.end,nextInterval.start,preInterval.start,preInterval.end};
                Arrays.sort(point);

                preInterval.start=point[0];
                preInterval.end=point[3];

                removeArray[j]=-1;
                if(j>i){
                    j=i-1;
                }
            }

        }
        for (int i = intervals.size()-1; i >=0; i--) {
            if(removeArray[i]==-1){
                intervals.remove(i);
            }
        }


        return intervals;

    }

}
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
