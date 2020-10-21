package blind;
import  java.util.*;
public class NumberofConnectedComponentsInUndirectedGraph {

    public static void dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> visited){
      
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()){
            Integer poppedNode = queue.poll();
            visited.add(poppedNode);

            for(Integer child: graph.get(poppedNode)){
                if(visited.contains(child) || queue.contains(child)){
                    continue;
                }
                queue.add(child);
            }
        }

    }

    
    public static int countComponents(int n, int[][] edges){

        if(edges.length  == 0){
            return n;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
                graph.get(edge[1]).add(edge[0]);
                graph.get(edge[0]).add(edge[1]);
            
        }
        int numberOfComponents = 0;

        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                dfs(i, graph, visited);
                numberOfComponents++;
            }
        }
        return numberOfComponents;


    }
    public static void main(String[] args){
        System.out.println("\n 323. Number of Connected Components in an Undirected Graph\n");

        int[][] edges = new int[][]{{0,1}, {1,2}, {3,4}};

        int[][] edges2 = new int[][]{{0,1}, {1,2}, {2,3}, {3,4}};
        System.out.println(countComponents(5, edges2));
    }
    
}
