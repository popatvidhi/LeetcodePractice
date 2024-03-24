package Matrix;

import java.util.Arrays;

public class SetMetrixZeros {

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,0,1},{1,0,1},{0,1,1}};
        System.out.println(Arrays.deepToString(matrix));
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        //Space O(1) Time O(m.n)
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowZero = false;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(matrix[r][c] == 0){
                    matrix[0][c] = 0;
                    if(r > 0){
                        matrix[r][0] = 0;
                    }else{
                        rowZero = true;
                    }
                }
            }
        }

        for(int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if(matrix[0][c] == 0 || matrix[r][0] == 0)
                    matrix[r][c] = 0;
            }
        }

        if(matrix[0][0] == 0){
            for(int r=0; r<row; r++)
                matrix[r][0] = 0;
        }

        if(rowZero)
            for(int c=0; c<col; c++)
                matrix[0][c] = 0;

    }
}
