import java.util.*;
public class NumberOfDistinctIslands {

    public static void exploreGrid(int[][] grid, int r, int c, String shp, StringBuilder shape){
        if(r < 0  || c < 0 || r>= grid.length || c>=grid[0].length || grid[r][c] == 0){
            return;
        }

        grid[r][c] =0 ;
        shape.append(shp);
        exploreGrid(grid, r-1, c, "1", shape);
        exploreGrid(grid, r+1, c, "2", shape);
        exploreGrid(grid, r, c-1, "3", shape);
        exploreGrid(grid, r, c+1, "4", shape);

        // Add this to ensure that all the islands visited are unique. Substitute this with any symbol you like
        // Treat it as a bridge to the next block for the island.
        shape.append(0);
    }
    public static void main(String[] args){
        System.out.println("\n694. Number of Distinct Islands\n");
        int[][] grid = new int[][]{{1,1,0}, {0,1,1},{0,0,0},{1,1,1},{0,1,0},};

        Set<String> distinctIslandShapes = new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder shape = new StringBuilder("");
                    exploreGrid(grid, i, j, "0",  shape);
                    distinctIslandShapes.add(shape.toString());
                }
            }
        }

        System.out.println("The number of distinct islands are : " + distinctIslandShapes.size());
        


    }
    
}