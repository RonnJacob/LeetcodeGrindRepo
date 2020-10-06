import java.util.*;
public class Dijkstra {

    public static int networkDelayTime(int[][] times, int N, int K) {
        int max = Integer.MIN_VALUE;
        // Create adjacency list.
        Map<Integer, List<int[]>> mp = new HashMap<>();
        for(int i=1; i<=N; i++){
            mp.put(i, new ArrayList<>());
        }

        // Creating the adjacency matrix.
        for(int[]time: times){
            mp.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[N+1];
        for(int i=1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{K,0});
        Set<Integer> nodesVisited = new HashSet<>();
        dist[K] = 0;
        

        while(nodesVisited.size() != N){
            int[] nodePopped = pq.poll();
            nodesVisited.add(nodePopped[0]);
            System.out.println("Popped Node: " + nodePopped[0]);
            for(int[] neighbors: mp.get(nodePopped[0])){
                int neighborNode = neighbors[0];
                System.out.println("Exploring Neighbor: " + neighborNode);
                int neighborCost = neighbors[1];
                if(!nodesVisited.contains(neighborNode)){
                    if(dist[nodePopped[0]] + neighborCost < dist[neighborNode]){
                        dist[neighborNode] = dist[nodePopped[0]] + neighborCost;
                        if(dist[neighborNode] > max){
                            max = dist[neighborNode];
                        }
                    }

                    pq.offer(new int[]{neighborNode, dist[neighborNode]});
                }
            }
        }

        return max;
    }

    public static void main(String[] args){

        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,5}};
        int N =4;
        int K = 2;
        System.out.println(networkDelayTime(times, N, K));


    }
    
}
