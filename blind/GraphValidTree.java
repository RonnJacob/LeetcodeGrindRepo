package blind;

import java.util.*;
public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges){
        if(edges.length  != n-1){
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
                graph.get(edge[1]).add(edge[0]);
                graph.get(edge[0]).add(edge[1]);
            
        }

        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
        Set<Integer> visited = new HashSet<>();


        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

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

        
        return visited.size() == n;
    }
    public static void main(String[] args){
        System.out.println("\n261. Graph Valid Tree");
        int[][] edges = new int[][]{{0,1}, {0,2}, {0,3}, {1,4}};
        int[][] edges2 = new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        int[][] edges3 = new int[][]{{0,1}, {2,3}};
        int[][] edges4 = new int[][]{{1,0}};
        System.out.println(validTree(4, edges3));
    }
}
