package Array;

public class Maximumsubarray {

    public static void main(String args[]){
        int res = 0;
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        res = maxSubArray(nums);
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {
       int max = nums[0];
       int sum = 0;
       for(int i=0; i<nums.length; i++){
           sum = nums[i] + sum;
           max = Math.max(sum, max);
           if(sum < 0)
               sum = 0;
       }
       return max;
    }
}