package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String args[]){
        int[][] result;
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        result = merge(intervals);
        System.out.println("Intervals ");
        for(int[] i : intervals){
            System.out.print(Arrays.toString(i));
        }
        System.out.println("\nResult ");
        for(int[] i : result){
            System.out.print(Arrays.toString(i));
        }
    }
    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
