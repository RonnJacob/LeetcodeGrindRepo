package blind;

import java.util.*;
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowC = matrix.length;
        int colC = matrix[0].length;
        boolean[][] seen = new boolean[rowC][colC];

        int[] d_r = {0,1,0,-1};
        int[] d_c = {1,0,-1,0};

        int r = 0, c = 0, d = 0;

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<rowC * colC; i++){
            seen[r][c] = true;
            result.add(matrix[r][c]);
            int cr  = d_r[d] + r;
            int cc = d_c[d] + c;
            if(0<=cr && cr <rowC && 0<=cc && cc < colC && !seen[cr][cc]){
                r = cr;
                c = cc;
            }
            else{
                d = (d+1) %4;
                r += d_r[d];
                c += d_c[d];
            }
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println("\n 54. Spiral Matrix");
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(mat).toString());


    }
    
}
