import java.util.*;
public class TarjanPractice{


    static List<List<Integer>> graph = new ArrayList<>();
    static int timer = 0;


    public static void tarjan(int currNode, int parent, int[] timestamps, boolean[] visited, List<List<Integer>> graph, List<List<Integer>> result){
        visited[currNode] = true;
        timestamps[currNode] = timer++;
        int currTimeStamp = timestamps[currNode];
        for(Integer neighbor: graph.get(currNode)){
            if(neighbor == parent) continue;
            if(!visited[neighbor]){
                tarjan(neighbor, currNode, timestamps, visited, graph, result);
            }
            timestamps[currNode] = Math.min(timestamps[currNode], timestamps[neighbor]);

            if(currTimeStamp < timestamps[neighbor]) {

                result.add(Arrays.asList(currNode, neighbor));
            }
        }
    }

    public static void buildGraph(int n, List<List<Integer>> connections){
        for(int i=0; i<n; i++){
            graph.add(i, new ArrayList<>());
        }

        for(List<Integer> connection: connections){
            int src = connection.get(0);
            int dest = connection.get(1);
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
    }
    
    public static void main(String[] args){
        System.out.println("\n Tarjan's Algorithm");
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        int n = 4;
        boolean[] visited = new boolean[n];
        int[] timestamps = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        buildGraph(n, connections);
        tarjan(0, -1, timestamps, visited, graph, result);

        System.out.println(result.toString());

    }

    
}