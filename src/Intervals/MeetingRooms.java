package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static Intervals.Interval.printIntervals;

public class MeetingRooms {
    public static void main(String args[]){
        List<Interval> intervals = List.of(
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        );
        printIntervals(intervals);
        boolean res = canAttendMeetings(intervals);
        System.out.println(res);

    }
    public static boolean canAttendMeetings(List<Interval> intervals) {
        //Convert the input list to a mutable ArrayList
        List<Interval> mutableIntervals = new ArrayList<>(intervals); // unncessary step
        mutableIntervals.sort(Comparator.comparingInt(i -> i.start));
        for(int i = 1; i < intervals.size(); i++){
            Interval currInterval = mutableIntervals.get(i);
            Interval prevInterval = mutableIntervals.get(i-1);

            if(prevInterval.end > currInterval.start){
                return false;
            }
        }
        return true;
    }

}
