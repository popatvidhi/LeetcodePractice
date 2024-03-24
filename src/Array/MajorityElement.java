package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String args[]){
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int res1 = majorityElement1(nums);
        System.out.println(res1);
        int res2 = majorityElement1(nums);
        System.out.println(res2);
    }

    //O(n) space
    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0, maxCount = 0;
        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
            if(count.get(num) > maxCount)
                res = num;
            maxCount = Math.max(count.get(num), maxCount);
        }
        return res ;
    }

    //O(1) space Boyer-Moore Voting Algorithm
    public static int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }else if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
