package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args){
        List<List<Integer>> res = combine(4,2);
        for(List<Integer> lis : res){
            System.out.print("[ ");
            for(Integer i : lis){
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    public static void backtrack(int n, int k, int start, List<Integer> combination, List<List<Integer>> res){
        if(k == combination.size()){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i < n + 1; i++){
            combination.add(i);
            backtrack(n, k, i + 1, combination, res);
            combination.remove(combination.size() -1);
        }
    }
}
