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


    public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int temp = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j] < arr[temp]){
                   temp = j;
                } 
            }
            if(temp != i){
                int t = arr[i];
                arr[i] = arr[temp];
                arr[temp] = t;
            }
        }
        return arr;
    }
    
    
    public static void main(String[] args){


        int  arr[]={100,20,15,30,5,75,40};
        System.out.println("\n Bubble Sort\n");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));


        int  arr2[]={100,20,15,30,5,75,40};
        System.out.println("\n Selection Sort\n");
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(selectionSort(arr2)));


    }
    
}
    