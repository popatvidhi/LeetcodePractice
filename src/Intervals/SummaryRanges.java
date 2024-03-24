package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> res= summaryRanges(nums);
        for(String s : res){
            System.out.print(s + " ");
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0;
        while(i < nums.length){
            int start = nums[i];
            int end = nums[i];
            while(i+1 < nums.length && nums[i+1] == nums[i] + 1){
                i++;
                end = nums[i];
            }
            if(start == end){
                res.add(String.valueOf(start));
            }else{
                res.add(start+"->"+end);
            }
            i++;
        }
        return res;
    }
}
