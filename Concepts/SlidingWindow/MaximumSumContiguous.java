package Concepts.SlidingWindow;

public class MaximumSumContiguous {

    public static int getMaxSumContiguous(int[] arr, int K){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(i>=K-1){
                if(sum > max){
                    max = sum;
                }
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args){
        System.out.println("\n Maximum sum of any contiguous subarray of size ‘k’");
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        int K = 3;
        getMaxSumContiguous(arr, K);
    }
    
}
