package blind;

import java.util.Arrays;
public class RotateImage {

    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int l = n; l>1; l-=2){
            int lo = (n-l)/2;

            int hi = lo+l-1;

            for(int i=0; i<l-1; i++){
                int temp = matrix[hi-i][lo];
                matrix[hi-i][lo] = matrix[hi][hi-i];
                matrix[hi][hi-i] = matrix[lo+i][hi];
                matrix[lo+i][hi] = matrix[lo][lo+i];
                matrix[lo][lo+i] = temp;
            }
        }
    }
    public static void main(String[] args){
        System.out.println("\n 48. Rotate Image ");
        int[][] mat = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

        rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }
    
}
