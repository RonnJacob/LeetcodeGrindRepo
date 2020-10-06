import java.util.*;
public class FindMedianfromDataStream {

    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;

    public FindMedianfromDataStream() {
        lo = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        hi = new PriorityQueue<>((a,b)->Integer.compare(a,b));
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());

        if(hi.size() > lo.size()){
            lo.offer(hi.poll());
        }
    }
    
    public void printQueue(){
        System.out.println("\nLo Max Heap");
        for(Integer d: lo){
            System.out.println(d + " ");
        }

        System.out.println("\nHi Min Heap");
        for(Integer d: hi){
            System.out.println(d + " ");
        }
        System.out.println();
    }
    public double findMedian() {
        if((lo.size() + hi.size()) % 2 == 0){
            return (double)(lo.peek() + hi.peek())/2.0;
        }
        else{
            return (double)lo.peek();
        }
    }

    
    public static void main(String[] args){
        System.out.println("\n295. Find Median from Data Stream");
        FindMedianfromDataStream s = new FindMedianfromDataStream();
        s.addNum(1);
        s.addNum(2);
        s.printQueue();
        System.out.println(s.findMedian());
    }
    
}
