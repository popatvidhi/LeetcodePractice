package Matrix;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String args[]){
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> squares = new HashMap<>();

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                if(rows.containsKey(r) && rows.get(r).contains(board[r][c]) ||
                        cols.containsKey(c) && cols.get(c).contains(board[r][c]) ||
                        squares.containsKey((r / 3) * 3 + c / 3) && squares.get((r / 3) * 3 + c / 3).contains(board[r][c])){
                    return false;
                }
                cols.computeIfAbsent(c, k -> new HashSet<>()).add(board[r][c]);
                rows.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c]);
                squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(board[r][c]);
                }
            }
        return true;
        }
}
