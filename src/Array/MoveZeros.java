package Array;

public class MoveZeros {

    public static void main(String args[]){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for(int num : nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i < nums.length){
            nums[i] = 0;
            i++;
        }
    }
}
