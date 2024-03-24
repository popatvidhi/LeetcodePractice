package Matrix;

import java.util.Arrays;

public class RotateImage {

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        //rotate in reverse order
        while ( l < r){
            for(int i = 0; i < r - l ; i++){
                int t = l;
                int b = r;
                //save top left
                int topleft = matrix[t][l+i];
                //move bottom left to top left
                matrix[t][l+i] = matrix[b-i][l];
                //move bottom right to bottom left
                matrix[b-i][l] = matrix[b][r-i];
                //move top right to bottom right
                matrix[b][r-i] = matrix[t+i][r];
                //move topleft to top roght
                matrix[t+i][r] = topleft;
            }
            l++;
            r--;
        }

    }
}
