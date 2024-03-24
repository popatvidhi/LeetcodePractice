package DynamicProgramming;

public class MinimumPathSum {

    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] res = new int[rows + 1][cols + 1];
        for(int r = 0; r < res.length; r++){
            for(int c = 0; c < res[0].length; c++){
                res[r][c] = Integer.MAX_VALUE;
            }
        }
        res[rows - 1][cols] = 0;
        for(int r = rows - 1; r >= 0; r--){
            for(int c = cols - 1; c >= 0; c--){
                res[r][c] = grid[r][c] + Math.min(res[r + 1][c], res[r][c + 1]);
            }
        }
        return res[0][0];
    }
}
