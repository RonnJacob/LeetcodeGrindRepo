import java.util.*;
public class FirstNonRepeatingIntegerInArray {


    public static int findFirstUnique(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
        }

        for(int i=0; i<arr.length; i++){
            if(mp.get(arr[i]) == 1){
                return arr[i];
            }
            
        }
        return -1;
    }

    
    public static int findSecondMaximum(int[] arr){
        int firstMax = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > firstMax){
                secondMax = firstMax;
                firstMax = arr[i];
            }
            else if(arr[i] > secondMax  && arr[i] < firstMax){
                secondMax = arr[i];
            }
        }
        return secondMax;

    }

    public static void rotateArray(int[] arr){
        int buffer = arr[0];
        int lastElement = arr[arr.length-1];
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            arr[i] = buffer;
            buffer = temp;
        }

        arr[0] = lastElement;
    }

  
    public static void main(String[] args){
        System.out.println("\n Hello World\n");
        int[] arr2 = new int[]{10, -1, 20, 4, 5, -9, -6};
        System.out.println(Arrays.toString(arr2));
    }
    
}

