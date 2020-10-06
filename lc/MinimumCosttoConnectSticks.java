import java.util.*;

public class MinimumCosttoConnectSticks {

    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> hp = new PriorityQueue<>();        
        for(int i=0; i<sticks.length; i++){
            hp.offer(sticks[i]);
        }
        int cost = 0;
        while(hp.size() >=2){
            int c = hp.poll() + hp.poll();
            cost += c;
            hp.add(c);
        }
        return cost;
    }

    public static void main(String[] args){
        System.out.println("\n1167. Minimum Cost to Connect Sticks");
        int[] sticks = new int[]{1,8,3,5};
        System.out.println("Sticks: " );
        for(int i=0; i<sticks.length; i++){
            System.out.print(sticks[i] + " ");
        }
        System.out.println("\nMinimum Cost To Connect Sticks: " + connectSticks(sticks));

    }
    
}