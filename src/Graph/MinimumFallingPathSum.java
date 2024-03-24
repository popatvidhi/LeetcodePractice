package Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumFallingPathSum {

    public static void main(String[] args){
        int[][] matrix = new int[][]{{2,1,3},
                                     {6,5,4},
                                     {7,8,9}};
        int res = minFallingPathSum(matrix);
        System.out.println(res);
        int res1 = minFallingPathSumDP(matrix);
        System.out.println(res1);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        for(int c = 0; c < n; c++){
            res = Math.min(dfs(0, c, n, matrix), res);
        }
        return res;
    }

    public static int dfs(int r, int c, int n, int[][] matrix){
        HashMap<List<Integer>, Integer> cache = new HashMap<>();
        if(r == n){
            return 0;
        }
        if(c < 0 || c == n){
            return Integer.MAX_VALUE;
        }
        if(cache.containsKey(Arrays.asList(r,c))){
            cache.get(Arrays.asList(r,c));
        }

        int res = matrix[r][c] + Math.min(Math.min(dfs(r+1, c-1, n, matrix), dfs(r+1, c+1, n, matrix)),
                                            dfs(r+1, c, n, matrix));

        cache.put(Arrays.asList(r,c),res);
        return res;
    }

    public static int minFallingPathSumDP(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[r][c];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i = 0; i < c; i++){
            res = Math.min(res, dfs(0, i, matrix, dp));
        }
        return res;
    }
    public static int dfs(int r, int c, int[][] matrix, int[][] dp){
        if(r == matrix.length){
            return 0;
        }
        if(c < 0 || c >= matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c] != Integer.MAX_VALUE){
            return dp[r][c];
        }

        int l = dfs(r + 1, c - 1, matrix, dp);
        int m = dfs(r + 1, c, matrix, dp);
        int n = dfs(r + 1, c + 1, matrix, dp);

        dp[r][c] = matrix[r][c] + Math.min(l, Math.min(m, n));
        return dp[r][c];
    }
}
