package Array;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String args[]){
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] res = intersect(nums1, nums2);
        for(int num : res){
            System.out.print(" "+num+" ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> intersection = new ArrayList<>();

        // Step 1: Populate HashSet with elements from arr1
        for (int num : nums1) {
            set.add(num);
        }

        // Step 2: Find intersection with elements from arr2
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
                set.remove(num); // Remove to avoid duplicates
            }
        }

        // Convert List to array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;

    }
}
