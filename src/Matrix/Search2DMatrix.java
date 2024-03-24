package Matrix;

public class Search2DMatrix {

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        while(top <= bottom){
            int row = top + (bottom - top) / 2;
            if(target > matrix[row][cols - 1]){
                top = row + 1;
            }else if(target < matrix[row][0]){
                bottom = row - 1;
            }else{
                break;
            }
        }
        if(!(top <= bottom)){
            return false;
        }
        int row = top + (bottom - top) / 2;
        int l = 0, r = cols - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(target > matrix[row][m]){
                l = m + 1;
            }else if(target < matrix[row][m]){
                r = m - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
