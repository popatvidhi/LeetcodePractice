package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String args[]){
        List<List<Integer>> res = generate(5);
        for(List<Integer> outer : res){
            System.out.print("[");
            for(Integer inner : outer){
                System.out.print(" "+inner);
            }
            System.out.println(" ]");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for(int i = 1; i < numRows; i++){
            List<Integer> preRow = res.get(i-1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for(int j = 1; j < i; j++){
                currRow.add(preRow.get(j-1) + preRow.get(j));
            }
            currRow.add(1);
            res.add(currRow);
        }
        return res;
    }
}
