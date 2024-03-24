package Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordSearch {

    public static void main(String args[]){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean res = exist(board,word);
        System.out.println(res);
    }
    public static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(word.charAt(0)==board[i][j] && dfs(i,j,word,board,0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, String word, char[][] board, int i){
        if(i == word.length())
            return true;
        if(r<0 || r>=board.length || c<0 || c>=board[r].length || word.charAt(i) != board[r][c] || visited[r][c]){
            return false;
        }
        visited[r][c]=true;
        if(dfs(r+1,c,word,board,i+1)||
                dfs(r-1,c,word,board,i+1)||
                dfs(r,c+1,word,board,i+1)||
                dfs(r,c-1,word,board,i+1))
            return true;

        visited[r][c]=false;
        return false;

    }

}
