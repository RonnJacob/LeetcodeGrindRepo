import java.util.*;

class Orange{
    int x;
    int y;
    int time;
}

public class RottingOranges {


    public static int orangesRotting(int[][] grid) {
        int result = 0;
        int nbOranges = 0;
        boolean usesDiagonals = false;
        Queue<Orange> queue = new LinkedList();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 0) continue;
                if (grid[y][x] == 2) {
                    Orange o = new Orange();
                    o.x = x;
                    o.y = y;
                    o.time = 0;
                    queue.offer(o);
                    visited[y][x] = true;
                }
                nbOranges++;
            }
        }
        
        while (!queue.isEmpty()) {
            Orange current = queue.poll();
            int x = current.x;
            int y = current.y;
            nbOranges--;
            
            if (current.time > result) {
                result = current.time;
            }
            
            for (int i = y - 1; i <= y + 1; i++) {
                for (int j = x - 1; j <= x + 1; j++) {
                    if (!usesDiagonals && (y - i != 0 && x - j != 0)) continue;
                    if (!isInBound(grid, j, i)) continue;
                    if (visited[i][j]) continue;
                    if (grid[i][j] != 1) continue;
                    Orange rottingOrange = new Orange();
                    rottingOrange.x = j;
                    rottingOrange.y = i;
                    rottingOrange.time = current.time + 1;
                    visited[i][j] = true;
                    grid[i][j] = 2;
                    queue.offer(rottingOrange);
                }
            }
        }
        
        return nbOranges > 0 ? -1 : result;
    }
    
    public static boolean isInBound(int[][] grid, int x, int y) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) return false;
        return true;
    }
    
    public static class Orange {
        public int x;
        public int y;
        public int time;
    }

    public static void main(String[] args){
        System.out.println("\n994. Rotting Oranges\n");
        int[][] grid = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}