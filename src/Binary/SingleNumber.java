package Binary;

public class SingleNumber {

    public static void main(String args[]){
        int nums[] = new int[]{4,1,2,1,2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
