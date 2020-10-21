package blind;
 import java.util.*;
public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
         boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
         boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

         // Number of Rows.
         int nRows = matrix.length;

         // Number of Columns.
         int nCols = matrix[0].length;

         List<List<Integer>> result = new ArrayList<>();

         for(int i=0; i<nRows; i++){
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            dfs(matrix, nRows-1, i, Integer.MIN_VALUE, atlantic);
         }

         for(int i=0; i<nCols; i++){
             dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
             dfs(matrix, i, nCols-1, Integer.MIN_VALUE, atlantic);
         }
         for(int i=0; i<nRows; i++){
             for(int j=0; j<nCols; j++){
                 if(pacific[i][j] && atlantic[i][j]){
                     System.out.println(i + "," + j);
                    result.add(Arrays.asList(i,j));
                 }
             }
         }
         return result;
    }

    public static void dfs(int[][] matrix, int r, int c, int prev, boolean[][] visited){

        if(r< 0 || c< 0 || r>= matrix.length || c>=matrix[0].length || visited[r][c] || matrix[r][c] < prev){
            return;
        }
        
        visited[r][c] = true;
        dfs(matrix, r-1, c, matrix[r][c], visited); // UP
        dfs(matrix, r, c-1, matrix[r][c], visited); // LEFT
        dfs(matrix, r+1, c, matrix[r][c], visited); // DOWN
        dfs(matrix, r, c+1, matrix[r][c], visited); // RIGHT
    }
    public static void main(String[] args){
        System.out.println("\n417. Pacific Atlantic Water Flow");

        int[][] nums = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic(nums);
    }
    
}
