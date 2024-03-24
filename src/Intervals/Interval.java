package Intervals;

import java.util.List;

public class Interval {
    int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }

    public static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
