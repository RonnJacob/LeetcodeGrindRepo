package SortingAlgorithms;

import java.util.Arrays;

public class Sorting {
    
    public static int[] bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    
    
    public static void main(String[] args){


        int  arr[]={100,20,15,30,5,75,40};

        
        System.out.println("\n Bubble Sort\n");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));

    }
    
}
    