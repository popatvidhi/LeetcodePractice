package Array;

public class FindPeakElement {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int res = findPeakElement(nums);
        System.out.println(res);
    }

    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid  > 0 && nums[mid] < nums[mid - 1]){
                r = mid - 1;
            }else if(mid  < nums.length - 1 && nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
