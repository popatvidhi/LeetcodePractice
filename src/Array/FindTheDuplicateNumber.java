package Array;

public class FindTheDuplicateNumber {

    public static void main(String args[]){
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicateBooleanArray(nums));
    }

    public static int findDuplicate(int[] nums) {
        //Floyd's Tortoise and Hare algorithm
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static int findDuplicateBooleanArray(int[] nums) {
        boolean[] exsists = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(exsists[nums[i]]){
                return nums[i];
            }else{
                exsists[nums[i]] = true;
            }
        }
        return -1;
    }
}
