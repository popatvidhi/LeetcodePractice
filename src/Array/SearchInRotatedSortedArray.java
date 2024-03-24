package Array;

public class SearchInRotatedSortedArray {
    public static void main(String args[]){
        int res = 0;
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        res = search(nums, target);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[left]) {
                if(target > nums[mid] && target <= nums[right] )
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if(target < nums[mid] && target >= nums[left])
                    right = mid -1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
