package Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class NonOverlappingIntervals {
    public static void main(String args[]){
        int result;
        int[][] intervals = new int[][]{{1,2},{2,3}};
        result = eraseOverlapIntervals(intervals);
        System.out.println("Intervals ");
        for(int[] i : intervals){
            System.out.print(Arrays.toString(i));
        }
        System.out.println("\nResult " + result);
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals == null){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= prevEnd){
                prevEnd = end;
            }else{
                res++;
                prevEnd = Math.min(end, prevEnd);
            }
        }
        return res;
    }
}
