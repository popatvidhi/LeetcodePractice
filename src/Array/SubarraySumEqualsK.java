package Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String args[]){
        int[] nums = {1,2,3};
        int k = 3;
        int res = subarraySum(nums, k);
        System.out.println(res);
    }
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int currSum = 0;
        for(int num : nums){
            currSum += num;
            int diff = currSum - k;
            res += prefixSumCount.getOrDefault(diff, 0);
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
