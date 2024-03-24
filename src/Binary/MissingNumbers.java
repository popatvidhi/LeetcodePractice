package Binary;

public class MissingNumbers {

    public static void main(String[] args){
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        int res = missingNumber(nums);
        System.out.println(res);
    }

    public static int missingNumber(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++){
            res += (i - nums[i]);
        }
        return res;
    }
}
