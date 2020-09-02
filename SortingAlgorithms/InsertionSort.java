package SortingAlgorithms;
import java.util.*;
public class InsertionSort {

    public static int[] insertionSort(int[] array){
        for (int j = 1; j < array.length; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
        return array;
    }
    public static void main(String[] args){
        System.out.println("\nInsertion Sort\n");
        int  arr[]={100,20,15,30,5,75,40};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(insertionSort(arr)));

    }
    
}