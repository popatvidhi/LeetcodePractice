package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        int target = 4;
        List<List<Integer>> res = combinationSum(nums, target);
        for(List<Integer> i : res){
            for(Integer j: i){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, candidates, target, res);
        return res;

    }
    public static void dfs(int i, List<Integer> curr, int total, int[] candidates, int target, List<List<Integer>> res){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= candidates.length || total > target){
            return;
        }
        curr.add(candidates[i]);
        dfs(i, curr, total + candidates[i], candidates, target, res);
        curr.remove(curr.size()-1);
        dfs(i+1, curr, total, candidates, target, res);
    }
}
