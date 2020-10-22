package blind;

import java.util.*;
public class WordSearch {


    public static boolean exist(char[][] board, String word){

        if(board.length == 0 || board[0].length == 0){
            return false;
        }

        if(word == null || word.trim().length() == 0 || word.equals(" ")){
            return false;
        }

        word = word.trim();
        int nRows = board.length;
        int nCols = board[0].length;
        for(int i=0; i<nRows; i++){
            for(int j=0; j<nCols;  j++){
                if(board[i][j] == word.charAt(0)){
                    System.out.println("\n Starting DFS");
                    boolean[][] visited = new boolean[nRows][nCols];
                    if(dfs(board, visited, i, j, word, 0)){
                        System.out.println(word + " has been found");
                        return true;
                    }
                    
                    
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, int idx){
        
        if(word.length() == 0){
            return true;
        }
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || idx >= word.length() ||  word.charAt(idx) != board[r][c]){
            return false;
        }

        
        visited[r][c] = true;


        System.out.println(board[r][c]);
        if(idx == word.length() -1){
            return true;
        }
        

        boolean left =  dfs(board, visited, r, c-1, word, idx+1); // LEFT
        boolean up = dfs(board, visited, r-1, c, word, idx+1); // UP
        boolean right = dfs(board, visited, r, c+1, word, idx+1); // RIGHT
        boolean down = dfs(board, visited, r+1, c, word, idx+1); // DOWN

        if( left || up || right || down){
            return true;
        }


        // VERY VERY IMPORTANT BECAUSE YOU HAVEN'T USED THE WORD IF IT FAILS SO ITS OPEN TO USE AGAIN.
        visited[r][c] = false;
        return false;

    }

    public static void main(String[] args){
        System.out.println("\n 79. Word Search");
        char[][] board  = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        exist(board, word);

    }
    
}
