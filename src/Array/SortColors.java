package Array;

public class SortColors {

    public static void main(String args[]){
        int[] nums = new int[]{2,0,2,1,1,0};
        System.out.println("Before :");
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+nums[i]+" ");
        }
        sortColors(nums);
        System.out.println();
        System.out.println("After :");
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+nums[i]+" ");
        }
    }

    public static void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        while(i <= r){
            if(nums[i] == 0){
                swap(l, i, nums);
                l++;
            }else if(nums[i] == 2){
                swap(r, i, nums);
                r--;
                i--;
            }
            i++;
        }
    }
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
