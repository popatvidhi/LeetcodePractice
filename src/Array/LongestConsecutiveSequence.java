package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

    public static void main(String args[]){
        int[] nums = new int[]{100,4,200,1,2,3};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max =  0;
        for(int num : nums){
            if(!set.contains(num - 1 )){
                int len = 0;
                while(set.contains(num + len)){
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
