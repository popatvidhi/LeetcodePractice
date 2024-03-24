package Array;

public class FindMinInRotatedSortedArray {
    public static void main(String args[]){
        int res = 0;
        int[] nums = new int[]{4,5,6,7,1,2};
        res = findMin(nums);
        System.out.println(res);
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums[0];
        while(left <= right){
            if(nums[left] < nums[right]){
                res = Math.min(nums[left], res);
                break;
            }
            int mid = left + (right - left)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] < nums[left]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
