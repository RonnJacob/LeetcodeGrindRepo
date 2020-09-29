import java.util.*;
public class MinCostToConnectAllEdges {


    // [1,2,3,4,5,6]
    // [-1,-1,-1,-1,-1,-1]

    // 1,2 | 1,3 | 2,3
    // 

    public int find(int[] parent, int i){
        if(parent[i] == -1){
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int a, int b){
        int x = find(parent, a);
        int y = find(parent, b);
        parent[x] = y;
    }

    class Edge{
        int src;
        int dst;
        int cost;
        Edge(int s, int d, int c){
            this.src = s;
            this.dst = d;
            this.cost = c;
        }
    }
    public int minimumCost(int N, int[][] connections) {
        int[] parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = -1;
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>((a,b)-> Integer.compare(a.cost, b.cost));

        for(int i=0; i<connections.length; i++){
            queue.offer(new Edge(connections[i][0], connections[i][1], connections[i][2]));
        }

        int totalCost = 0;
        while(!queue.isEmpty()){
            Edge poppedEdge = queue.poll();
            int srcPop = poppedEdge.src;
            int destPop = poppedEdge.dst;
            int costPop = poppedEdge.cost;

            System.out.println("Popped out edge : "+ srcPop + " -> " + destPop);

            int x = find(parent, srcPop);
            int y = find(parent, destPop);
            System.out.println("Before Union: Set Parent of "+srcPop + " : " + x + " | " + "Set Parent of "+destPop + " : " + y);
            if(x != y){
                System.out.println("Unioning");
                totalCost += costPop;
                union(parent, x, y);
            }

            System.out.println("After Union: Set Parent of "+srcPop + " : " +find(parent, srcPop) + " | " + "Set Parent of "+destPop + " : " + find(parent, destPop));
            System.out.println();
        }


        System.out.println(Arrays.toString(parent));
        int counter = 0;
        for(int i=1; i<=N; i++){
            if(counter ==2){
                return -1;
            }
            if(parent[i] ==-1){
                counter++;
            }
        }

        return totalCost;
    }    

    
    public static void main(String[] args){
        System.out.println("\n1135. Connecting Cities With Minimum Cost");
        int[][] connections = new int[][]{{1,2,1},{1,3,2},{3,4,4},{1,4,3}};
        int N = 4;
        MinCostToConnectAllEdges sol = new MinCostToConnectAllEdges();
        System.out.println(sol.minimumCost(N, connections));
    }
    
}
