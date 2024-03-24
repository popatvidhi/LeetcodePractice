package Array;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+nums[i]+" ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int dup = 1;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[k] == nums[i]){
                if(dup < 2){
                    nums[++k] = nums[i];
                    dup++;
                }
            }else{
                nums[++k] = nums[i];
                dup = 1;
            }
        }
        return k + 1;
    }
}
