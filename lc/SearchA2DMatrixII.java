public class SearchA2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int r = matrix.length-1;
        int c = 0;

        while(r>=0 && c<matrix[0].length){
            if(matrix[r][c] < target){
                c++;
            }
            else if(matrix[r][c] > target) {
                r--;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("\n240. Search a 2D Matrix II");
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(arr, 22));
    }
    
}
