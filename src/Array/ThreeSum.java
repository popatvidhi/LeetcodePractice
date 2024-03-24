package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String args[]){
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        res = threeSum(nums);
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && nums[i] <=0; i++) {
            //avoid duplicate
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }
    private static void twoSumII(int[] nums, int i, List<List<Integer>> res){
        int l = i + 1;
        int r = nums.length - 1;
        while(l < r){
            int sum = nums[i] + nums[l] + nums[r];
            if(sum > 0){
                r--;
            }else if(sum < 0){
                l++;
            }else{
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                //avoid duplicate
                while(nums[l]==nums[l-1] && l<r)
                    l++;
            }
        }

    }
}
