package Array;

class ProductToSelf {
    public static void main(String args[]){
        int [] res = new int[4];
        int[] nums = new int[]{1,2,3,4};
        res = productExceptSelf(nums);
        for(int i = 0; i<res.length; i++)
            System.out.print(res[i] +" ");

    }
public static int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int temp[] = new int[nums.length];
        for (int i =0; i<nums.length; i++){
            temp[i] = 1;
        }
        for(int i=0; i<nums.length; i++){
            temp[i] = pre * temp[i];
            pre = pre * nums[i];
        }
        for(int i= nums.length-1; i>=0; i--){
            temp[i] = post * temp[i];
            post = post * nums[i];
        }
        return temp;
        }
}