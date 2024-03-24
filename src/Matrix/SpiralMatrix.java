package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.deepToString(matrix));
        List<Integer> res = spiralOrder(matrix);
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        //Space O(1) Time O(m.n)
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while(left < right && top < bottom){
            //go right
            for(int i = left; i < right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            //go bottom
            for(int i = top; i < bottom; i++){
                res.add(matrix[i][right-1]);
            }
            right--;

            if(!(left < right && top < bottom))
                break;
            //go left
            for(int i = right - 1; i >= left; i--){
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            //go top
            for(int i = bottom - 1; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
