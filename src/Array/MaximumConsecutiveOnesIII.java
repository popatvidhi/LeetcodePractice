package Array;

public class MaximumConsecutiveOnesIII {

    public static void main(String args[]){
        int nums[] = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int res = longestOnes(nums, k);
        System.out.println(res);
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                k--;
            }
            if(k < 0){
                if(nums[l] == 0){
                    k++;
                }
                l++;
            }
            r++;
        }
        return r - l ;
    }
}
