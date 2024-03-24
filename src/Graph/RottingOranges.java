package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args){
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        int res = orangesRotting(grid);
        System.out.println(res);
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;;
        int cols = grid[0].length;
        Queue<int[]> qu = new ArrayDeque<>();
        int time = 0, fresh = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    qu.add(new int[]{r,c});
                }
            }
        }
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!qu.isEmpty() && fresh > 0){
            int size = qu.size();
            for(int i = 0; i < size; i++){
                int[] current = qu.poll();
                int r = current[0];
                int c = current[1];
                for(int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row < 0 || row == rows || col < 0 || col == cols || grid[row][col] != 1){
                        continue;
                    }
                    grid[row][col] = 2;
                    qu.offer(new int[]{row,col});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
