import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {

        return Arrays.stream(A).map(number -> number * number).sorted().toArray();
    }
    public static void main(String[] args){
        System.out.println("\n977. Squares of a Sorted Array");
        int[] arr= new int[]{-4,-1,0,3,10};
        SquaresOfASortedArray s = new SquaresOfASortedArray();
        System.out.println(s.sortedSquares(arr));
    }
    
}
