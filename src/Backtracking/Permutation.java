package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> lis : res){
            System.out.print("[ ");
            for(Integer i : lis){
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<>(), used);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used){
        if(nums.length == temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, res, temp, used);
                used[i] = false;
                temp.remove(temp.size() - 1 );
            }
        }
    }
}
