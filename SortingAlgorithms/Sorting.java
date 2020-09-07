package SortingAlgorithms;

import java.util.Arrays;

public class Sorting {
    
    // BUBBLE SORT
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


    // SELECTION SORT
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


    // INSERTION SORT
    public static int[] insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int element = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > element){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
        return arr;
    }

    // MERGE SORT
    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l +1;
        int n2 = r-m;
        int i,j,k;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for(i=0; i<n1; i++){
            L[i] = arr[l+i];
        }

        for(j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }

        i=0;
        j=0;
        k=l;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    // QUICKSORT - O(n) Best Case | O(n^2) - Worst Case | Not stable | In Place 
    public static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l-1;

        for(int j=l; j<r; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l<r){
            int pi = partition(arr, l, r);

            quickSort(arr, l, pi-1);
            quickSort(arr, pi+1, r);

        }
    }
    

    // HEAP SORT

    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }
        
        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }
        
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void heapsort(int[] arr){
        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, arr.length, i);
        }

        for(int i=arr.length-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);

        }

        
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

        int  arr3[]={100,20,15,30,5,75,40};
        System.out.println("\n Insertion Sort\n");
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(insertionSort(arr3)));

        int  arr4[]={100,20,15,30,5,75,40};
        System.out.println("\n Merge Sort\n");
        System.out.println(Arrays.toString(arr4));
        mergeSort(arr4, 0, 6);
        System.out.println(Arrays.toString(arr4));

        int  arr5[]={100,20,15,30,5,75,40};
        System.out.println("\n Quick Sort\n");
        System.out.println(Arrays.toString(arr5));
        quickSort(arr5, 0, 6);
        System.out.println(Arrays.toString(arr5));

        int  arr6[]={100,20,15,30,5,75,40};
        System.out.println("\n Heap Sort\n");
        System.out.println(Arrays.toString(arr6));
        heapsort(arr6);
        System.out.println(Arrays.toString(arr6));


    }
    
}
    