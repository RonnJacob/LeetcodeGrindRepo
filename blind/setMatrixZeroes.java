package blind;
import java.util.*;
public class setMatrixZeroes {

    public static void setZeroes(int[][] matrix){
        boolean rowSet = false;
        boolean colSet = false;
        int rowC = matrix.length;
        int colC =matrix[0].length;
        int temp = matrix[0][0];

        for(int i=0; i<colC; i++){
            if(matrix[0][i] == 0){
                rowSet = true;
            }
        }
        for(int i=0; i<rowC; i++){
            if(matrix[i][0] == 0){
                colSet = true;
            }
        }
        for(int i= 0; i<rowC; i++){
            for(int j=0; j<colC; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<rowC; i++){
            for(int j=1; j<colC; j++){
                if(matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }

                if(matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowSet){
            for(int i=0; i<colC; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(colSet){
            for(int i=0; i<rowC; i++){
                matrix[i][0] = 0;
            }
        }

        if(!rowSet && !colSet){
            matrix[0][0] = temp;
        }
    }

    public static void main(String[] args){
        System.out.println("\n 73. Set Matrix Zeroes");
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] matrix2 = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        setZeroes(matrix2);

        System.out.println(Arrays.deepToString(matrix2));
        
    }
    
}
