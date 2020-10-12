import java.util.*;

public class ArraysGrind{

    // We're trying to fit in the requirements for this function which basically
    // rearranges the minimum numbers and maximum numbers

    // This is the O(1) space way of doing this function with a runtime complexity of O(n).
    public static void reArrangeSortedArrayMaxMin(int[] arr){
        int[] result = new int [arr.length];
        int start = 0;
        int end = arr.length-1;
        int ptr = 0;
        while(start<end){
            result[ptr++] = arr[end--];
            result[ptr++] = arr[start++];
        }

        if(start == end){
            result[ptr] = arr[start];
        }
        System.out.println(Arrays.toString(result));
    }

    // This is the O(1) space and O(1) runtime. We would always need to store information about
    // the future values of the index in the arrary and find a way to encode the result to make
    // in-place changes. 
    
    public static void reArrangeSortedArrayMaxMinSpaceOptimized(int[] arr){

        int maxIdx = arr.length-1;
        int minIdx = 0;
        int maxElem = arr[maxIdx]+1;
        for(int i=0; i<arr.length; i++){
            if(i%2==0){
                arr[i] += (arr[maxIdx--] % maxElem) * maxElem;
            }
            else{
                arr[i] += (arr[minIdx++] % maxElem) * maxElem;
            }
        }

        for(int i=0; i<arr.length; i++){
            arr[i] /= maxElem;
        }
        System.out.println(Arrays.toString(arr));
    }


    // Kadane's Algorithm

    public static int kadaneAlgorithm(int[] arr){
        int currMax = arr[0];
        int globalMax = arr[0];

        for(int i=1; i<arr.length; i++){
            if(currMax < 0){
                currMax = arr[i];
            }
            else{
                currMax += arr[i];
            }

            if(globalMax < currMax){
                globalMax = currMax;
            }

        }
        return globalMax;
    }
    public static void main(String[] args){
        System.out.println("\n Hello World !");
        int[] arr = new int[] {1,2,3,4,5,6,7};
        int arr2[] = new int[1]{1};

        // Runtime - O(n) | Space complexity - O(n)
        reArrangeSortedArrayMaxMin(arr);

        // Runtime - O(n) | Space complexity - O(1)
        reArrangeSortedArrayMaxMinSpaceOptimized(arr);

        int[] kadaneTest =new int[]{1, 7, -2, -5, 10, -1};
        System.out.println(kadaneAlgorithm(kadaneTest));

    }
}