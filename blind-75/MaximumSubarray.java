public class MaximumSubarray {
    public static int maximumSubarray(int[] arr){
        int curr_local_max = arr[0];
        int max_so_far = arr[0];
        for(int i=1; i<arr.length; i++){
            if(curr_local_max < 0){
                curr_local_max = arr[i];
            }   
            else{
                curr_local_max += arr[i];
            }
            if(curr_local_max > max_so_far){
                max_so_far = curr_local_max;
            }
        }   x
        return max_so_far;
    }
    public static void main(String[] args){
        System.out.println("\n Blinds:: Maximum Subarray");
        int[] arr = new int[]{-2,1,-3,5};
        System.out.println(maximumSubarray(arr));
    }
}