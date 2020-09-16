public class SlidingWindowMaximum{
    public static int[] slidingWindowMax(int[] arr){
        if(arr.length == 0){
            return new int[]{};
        }
        
        int firstLargest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > firstLargest){

                if(secondLargest != Integer.MIN_VALUE){
                    secondLargest  = firstLargest;
                }

                firstLargest = arr[i];
            }
            else if(arr[i]> secondLargest){
                secondLargest = arr[i];
            }
        }

       
        return new int[]{firstLargest, secondLargest};
        
    }

    public static void slider(int[] arr, int k){
        int[] firstSecondLargest = slidingWindowMax(arr);
        int firstLargest = firstSecondLargest[0];
        int secondLargest = firstSecondLargest[1];
        for(int i=1; i+k<=arr.length; i++){
            
        }
        
    }
    public static void main(String[] args){
        System.out.println("\n Trial");
        int[] arr = new int[]{18,2,3, 20};
        slidingWindowMax(arr);
    }
}