package Array;

public class MinimumSizeSubarraySum {

    public static void main(String args[]){
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int resLen = Integer.MAX_VALUE;
        int sum = 0;
        while(r < nums.length){
            sum = sum + nums[r];
            r++;
            while(sum >= target){
                resLen = Math.min(resLen, r - l );
                sum = sum - nums[l];
                l++;
            }
        }

        return (resLen != Integer.MAX_VALUE) ? resLen : 0;
    }
}
