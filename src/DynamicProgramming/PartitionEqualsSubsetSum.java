package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualsSubsetSum {

    public static void main(String args[]){
        int[] nums = {1,2,3,4,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i = nums.length - 1; i >= 0; i--){
            Set<Integer> localDP= new HashSet<>();
            for(int t : dp){
                localDP.add(t + nums[i]);
                localDP.add(t);
            }
            dp = localDP;
        }
        return dp.contains(target);
    }
}
