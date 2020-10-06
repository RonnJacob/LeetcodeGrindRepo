import java.util.*;

public class ShortestPathinBinaryMatrix {

    static Queue<List<Integer>> queue;
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        int r = 0;
        int c = 0;
        queue = new LinkedList<>();
        int[][] distance = new int[grid.length][grid[0].length];
        queue.add(Arrays.asList(0,0));
        distance[0][0] = 1;
        while(!queue.isEmpty()){
            List<Integer> coord = queue.remove();
            r = coord.get(0);
            c = coord.get(1);
            if(grid[r][c]== 1){
                return -1;
            }
            modifyDistance(distance, r-1, c, distance[r][c], grid);
            modifyDistance(distance, r+1, c, distance[r][c], grid);
            modifyDistance(distance, r, c-1, distance[r][c], grid);
            modifyDistance(distance, r, c+1, distance[r][c], grid);
            modifyDistance(distance, r+1, c-1, distance[r][c], grid);
            modifyDistance(distance, r-1, c+1, distance[r][c], grid);
            modifyDistance(distance, r+1, c+1, distance[r][c], grid);
            modifyDistance(distance, r-1, c-1, distance[r][c], grid);
        }

        if(distance[grid.length-1][grid[0].length-1] == 0){
            return -1;
        }
        return distance[grid.length-1][grid[0].length-1];
    }

    public static void modifyDistance(int[][] distance, int r, int c, int currDistance, int[][] grid){
        if(r>=0 && c>=0 && r<distance.length && c<distance[0].length && grid[r][c] != 1 && distance[r][c] == 0){
            queue.add(Arrays.asList(r,c));
            distance[r][c] = currDistance+1;
        }
    }
    
    
    public static void main(String[] args){
        System.out.println("\n1091. Shortest Path in Binary Matrix\n");
        int[][] test1 = new int[][] {{0,1}, {1,0}};
        int[][] test2 = new int[][] {{0,0,0}, {1,1,0}, {1,1,0}};
        int[][] test3 = new int[][] {{0,1},{1,0},{0,0}};
        int[][] test4 = new int[][] {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}};

        System.out.println(shortestPathBinaryMatrix(test1));

    }
    
}