import java.util.*;
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {

        // Map for all the edges
        Map<Integer, List<int[]>> edgeCosts = new HashMap<>();
        int[] dist = new int[N+1];
        Set<Integer> visitedNodes = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1] - b[1]);

        // Populate the map with edges.
        queue.offer(new int[]{K, 0});
        for(int i=1; i<=N; i++){
            edgeCosts.put(i, new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = Integer.MAX_VALUE;
        dist[K] = 0;

        for(int[] time: times){
            edgeCosts.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        // We have added the first node as the source node to the queue.

        while(visitedNodes.size() != N && !queue.isEmpty()){
            int[] poppedNode = queue.poll();
            System.out.println(Arrays.toString(poppedNode));
            int poppedNodeVal = poppedNode[0];
            int poppedNodeCost = poppedNode[1];

            visitedNodes.add(poppedNodeVal);

            for(int[] edge: edgeCosts.get(poppedNodeVal)){
                int edgeNode = edge[0];
                int edgeNodeCost = edge[1];

                if(!visitedNodes.contains(edgeNode)){
                    if(poppedNodeCost + edgeNodeCost < dist[edgeNode]){
                        dist[edgeNode] = poppedNodeCost + edgeNodeCost;
                    }
                    queue.offer(new int[]{edgeNode, dist[edgeNode]});
                }
            }
        }

        if(visitedNodes.size() != N){
            return -1;
        }

         
        System.out.println(Arrays.toString(dist));
        int max = -1;
        for(int i=1; i<=N; i++){
            if(dist[i] > max){
                max = dist[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[][] times = new int[][]{{1,2,1}, {2,3,2}, {1,3,2}};
        int N = 3;
        int K = 1;
        NetworkDelayTime solution = new NetworkDelayTime();
        System.out.println(solution.networkDelayTime(times, N, K));


    }
    
}
