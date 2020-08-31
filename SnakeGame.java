import java.util.*;
public class SnakeGame{
    private LinkedList<Point> queue;
    private int rows, cols, score;
    private int[][] food;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;
        this.score = 0;
        this.queue = new LinkedList<>();
        this.queue.add(new Point(0,0));
    }

    public int move(String direction) {
        Point curr = new Point(queue.peek().x, queue.peek().y);
        if (direction.equals("U")) curr.x--;
        else if (direction.equals("L")) curr.y--;
        else if (direction.equals("R")) curr.y++;
        else if (direction.equals("D")) curr.x++;
        
        if (curr.x < 0 || curr.x >= rows || curr.y < 0 || curr.y >= cols) return -1;
        
        for (int i = 1; i < queue.size() - 1; i++) 
            if (queue.get(i).isEqual(curr)) return -1;
        
        queue.addFirst(curr);
        
        if (score < food.length && curr.x == food[score][0] && curr.y == food[score][1]) score++;
        else {
            queue.removeLast();
        }
        
        return score;
    }
    
    private static class Point {
        private int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        
        public boolean isEqual(Point other) {
            return this.x == other.x && this.y == other.y;
        }
    }

    public static void main(String[] args){
        System.out.println("\n353. Design Snake Game\n");
        
    }
}