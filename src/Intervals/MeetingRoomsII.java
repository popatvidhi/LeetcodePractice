package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static Intervals.Interval.printIntervals;

public class MeetingRoomsII {
    public static void main(String args[]){
        List<Interval> intervals = List.of(
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        );
        printIntervals(intervals);
        int res = minMeetingRooms(intervals);
        System.out.println(res);

    }

    public static int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int count = 0;
        int res = 0;
        int s = 0;
        int e = 0;

        for(int i = 0; i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        while(s < intervals.size()){
            if(start[s] < end[e]){
                s++;
                count++;
            }else{
                e++;
                count--;
            }
            res = Math.max(res,count);
        }
        return res;
    }

}
