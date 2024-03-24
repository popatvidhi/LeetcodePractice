package Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String args[]){
        int[][] result;
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};
        result = insert(intervals, newInterval);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++)
             System.out.print(result[i][j] + " ");
        }

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        // Handle the case when the intervals array is empty
        if (intervals.length == 0) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }

        boolean added = false; //flag to track is new interval is added or not

        for(int i = 0; i < intervals.length; i++){
            //add interval to start
            if(newInterval[1] < intervals[i][0]){
                if(!added){
                    res.add(newInterval);
                    added = true;
                }
                while(i < intervals.length){
                    res.add(intervals[i]);
                    i++;
                }
                break;
            }
            //add to the end
            else if(newInterval[0] > intervals[i][1]){
                res.add(intervals[i]);
            }
            //merge intervals
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if(!added){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
