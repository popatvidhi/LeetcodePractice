package Array;

public class JumpGame {

    public static void main(String arg[]){
        int[] nums = new int[]{2,3,1,1,4};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] + i >= goal){
                goal = i;
            }
        }
        return goal == 0 ? true : false;
    }
}
