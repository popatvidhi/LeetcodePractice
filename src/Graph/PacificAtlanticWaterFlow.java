package Graph;

import java.util.*;

public class PacificAtlanticWaterFlow {

    public static void main(String args[]){
        int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = pacificAtlantic(heights);
        for(List<Integer> i : res){
            for(Integer j : i)
             System.out.print(j + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++){
            dfs(0,c,pac,heights,heights[0][c]);
            dfs(ROWS - 1, c, atl, heights, heights[ROWS-1][c]);
        }

        for(int r = 0; r < ROWS; r++){
            dfs(r,0,pac,heights,heights[r][0]);
            dfs(r, COLS-1, atl, heights, heights[r][COLS-1]);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pac[i][j] && atl[i][j])
                    result.add(List.of(i,j));
            }
        }
        return result;
    }
    public static void dfs(int r, int c, boolean[][] visited, int[][] heights, int prevHeight){
        int ROWS = heights.length, COLS = heights[0].length;
        if(r<0 || c<0 || r>=ROWS || c>=COLS || visited[r][c] || prevHeight > heights[r][c])
            return;

        visited[r][c] = true;
        dfs(r+1,c,visited,heights,heights[r][c]);
        dfs(r-1,c,visited,heights,heights[r][c]);
        dfs(r,c+1,visited,heights,heights[r][c]);
        dfs(r,c-1,visited,heights,heights[r][c]);
    }
}
