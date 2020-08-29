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
            
            if (checkValidRange(x, y - 1, grid.length, grid[0].length) && !visited[y - 1][x] && grid[y - 1][x] == 1) {
                Orange north = new Orange();
                north.x = x;
                north.y = y - 1;
                north.time = current.time + 1;
                queue.offer(north);
                visited[y - 1][x] = true;
                grid[y - 1][x] = 2;
            }
            
            if (checkValidRange(x, y + 1, grid.length, grid[0].length) && !visited[y + 1][x] && grid[y + 1][x] == 1) {
                Orange south = new Orange();
                south.x = x;
                south.y = y + 1;
                south.time = current.time + 1;
                queue.offer(south);
                visited[y + 1][x] = true;
                grid[y + 1][x] = 2;
            }
            
            if (checkValidRange(x - 1, y, grid.length, grid[0].length) && !visited[y][x - 1] && grid[y][x - 1] == 1) {
                Orange west = new Orange();
                west.x = x - 1;
                west.y = y;
                west.time = current.time + 1;
                queue.offer(west);
                visited[y][x - 1] = true;
                grid[y][x - 1] = 2;
            }
            
            if (checkValidRange(x + 1, y, grid.length, grid[0].length) && !visited[y][x + 1] && grid[y][x + 1] == 1) {
                Orange east = new Orange();
                east.x = x + 1;
                east.y = y;
                east.time = current.time + 1;
                queue.offer(east);
                visited[y][x + 1] = true;
                grid[y][x + 1] = 2;
            }
        }
        
        return nbOranges > 0 ? -1 : result;
    }


    public static boolean checkValidRange(int x, int y, int totRow, int totCol){
        if(x < 0 || y < 0 || x >= totRow || y >= totCol){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("\n994. Rotting Oranges\n");
        int[][] grid = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(initialize(grid));
    }
}