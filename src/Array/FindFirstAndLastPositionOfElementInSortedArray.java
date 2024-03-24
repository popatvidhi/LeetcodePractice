package Array;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        for(int r : res){
            System.out.print(r + " ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;

    }
    //if leftBaise = true i.e looking for leftmost index else finding rightmost index
    public static int binarySearch(int[] nums, int target, boolean leftBais){
        int l = 0;
        int r = nums.length - 1;
        int i = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                i = mid;
                if(leftBais){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return i;
    }
}
