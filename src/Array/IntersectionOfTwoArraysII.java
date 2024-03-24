package Array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String args[]){
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] res = intersect(nums1, nums2);
        for(int num : res){
            System.out.print(" "+num+" ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();

        for(int num : nums1){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            if(frequency.containsKey(num) && frequency.get(num) > 0){
                intersection.add(num);
                frequency.put(num, frequency.get(num) - 1);
            }
        }
        int[] res = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++){
            res[i] = intersection.get(i);
        }
        return res;
    }
}
