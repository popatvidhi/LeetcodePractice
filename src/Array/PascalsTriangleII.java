package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static void main(String args[]){
        List<Integer> res = getRow(3);
        for(int n : res){
            System.out.println(n + " ");
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 1; i <= rowIndex; i++){
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            for(int j = 1; j < res.size(); j++){
                nextRow.add(res.get(j) + res.get(j - 1));
            }
            nextRow.add(1);
            res = nextRow;
        }
        return res;
    }
}
