package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        int startIndex=0;
        int locationflag=-1;

        //TODO:先把intervals合并
        if(intervals==null||intervals.size()==0){
            intervals=new ArrayList();
            intervals.add(newInterval);
            return intervals;
        }
        Interval pre=intervals.get(0);

        for (int i = 1; i < intervals.size()-1; i++) {
            Interval next=intervals.get(i);
            if(next.start<=pre.end){
                pre.end=Math.max(pre.end,next.end);
                intervals.remove(i);
                i--;
            }else {
                pre=intervals.get(i);
            }
        }


        for (int i = 0; i < intervals.size(); i++) {
            Interval cur=intervals.get(i);
            if(newInterval.start<cur.start){
                startIndex=i;
                locationflag=-1;
                break;
            }else if(newInterval.start>cur.end){
                startIndex=i;
                locationflag=1;
            }else {
                startIndex=i;
                locationflag=0;
                break;
            }
        }

        for (int i = startIndex; i < intervals.size(); i++) {
            Interval cur=intervals.get(i);

            if(locationflag==-1){
                if(newInterval.end<cur.start){
                    intervals.add(i,newInterval);
                    return intervals;
                }
                if(newInterval.end<=cur.end){
                    cur.start=newInterval.start;
                    return intervals;
                }
                if(newInterval.end>cur.end){
                    if(i==intervals.size()-1){
                        cur.start=newInterval.start;
                        cur.end=newInterval.end;
                    }else {
                        intervals.remove(i);
                        i--;
                    }
                }
            }else if(locationflag==0){
                if(newInterval.end<=cur.end){
                    return intervals;
                }

                if(i<intervals.size()-1){
                    //如果不是最后一个元素
                    if(newInterval.end>cur.end){
                        if(newInterval.end<intervals.get(i+1).start){
                            cur.end=newInterval.end;
                            return intervals;
                        }
                        if(newInterval.end>=intervals.get(i+1).start
                                &&newInterval.end<=intervals.get(i+1).end){
                            cur.end=intervals.get(i+1).end;
                            intervals.remove(i+1);
                            return intervals;
                        }
                        if(newInterval.end>intervals.get(i+1).end){
                            intervals.remove(i+1);
                            i--;
                            continue;
                        }
                    }


                }else {
                    cur.end=newInterval.end;
                    return intervals;
                }

            }else {
                //如果不是最后一个元素
                if(i<intervals.size()-1){
                    if(newInterval.end<intervals.get(i+1).start){
                        intervals.add(i+1,newInterval);
                        return intervals;
                    }

                    if(newInterval.end>=intervals.get(i+1).start&&newInterval.end<=intervals.get(i+1).end){
                        intervals.get(i+1).start=newInterval.start;
                        return intervals;
                    }

                    if(newInterval.end>intervals.get(i+1).end){
                        intervals.remove(i+1);
                        i--;
                        continue;
                    }

                }else {
                    intervals.add(newInterval);
                    return intervals;
                }

            }
        }

        return intervals;

    }
}
