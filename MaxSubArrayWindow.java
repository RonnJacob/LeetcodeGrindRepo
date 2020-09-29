import java.util.*;
public class MaxSubArrayWindow {

    

    public static void SubArrayMax(int[] arr, int k){
        Deque<Integer> windowElements = new LinkedList<>();
        

        int startWindow = 0;
        for(int i=0; i<=arr.length; i++){
            if(i-startWindow>=k){
                System.out.println(arr[windowElements.peekFirst()]);
                while(!windowElements.isEmpty() && windowElements.peekFirst() < startWindow+1){
                    windowElements.removeFirst();
                }
                startWindow++;
                if(i == arr.length){
                    return;
                }
            }
            while(!windowElements.isEmpty() && arr[windowElements.peekLast()] < arr[i]){
                windowElements.removeLast();
            } 
            windowElements.add(i);
            System.out.println(windowElements.toString());
            
        }
        System.out.println(windowElements.toString());


        // 4 2 3 1

        // 4 3
    }
    public static void main(String[] args){
        System.out.println("\n Window");
        int[] arr = new int[]{1,2,3,1,4,5,2,3,6};
        SubArrayMax(arr,3);
    }
    
}
