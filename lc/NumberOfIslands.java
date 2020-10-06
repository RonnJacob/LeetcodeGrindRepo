public class NumberOfIslands {


    public static void dfs(char[][] grid, int r, int c){
        if(r<0 || c< 0 || r>=grid.length || c>= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
    public static int numIslands(char[][] grid) {
        int counter = 0;   
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] != '0'){
                    dfs(grid, i, j);
                    counter++;
                }
            }
        }
        return counter; 
    }

    public static void printCharArray(char[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args){
        System.out.println("\n200. Number of Islands\n");

        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},
                                     {'1','1','0','0','0'},{'0','0','0','0','0'}};
        printCharArray(grid);
        System.out.println("The number of islands for this matrix is " + numIslands(grid) + "\n");

        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},
                                     {'0','0','1','0','0'},{'0','0','0','1','1'}};
        printCharArray(grid2);
        System.out.println("The number of islands for this matrix is " + numIslands(grid2) + "\n");
        
    }
    
}