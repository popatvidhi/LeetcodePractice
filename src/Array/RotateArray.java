package Array;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {

    public static void main(String args[]){
        int nums[] = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate1(nums, k);
        System.out.println("Solution in O(n) : ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+nums[i]+" ");
        }
        rotate2(nums, k);
        System.out.println("\n Solution in O(1) : ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(" "+nums[i]+" ");
        }
    }
    //O(n)
    public static void rotate1(int[] nums, int k) {
        int res[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            res[(i+k) % nums.length] = nums[i];
        }
        for(int i = 0; i < res.length; i++){
            nums[i] = res[i];
        }
    }
    //O(1)
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int l, int r){
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
            }
    }
 }

