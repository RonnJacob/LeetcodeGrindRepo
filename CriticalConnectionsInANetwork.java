import java.util.*;
public class CriticalConnectionsInANetwork {

    static List<List<Integer>> graph = new ArrayList<>();
    static int numNodes = 0;


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

    public static void dfs(int currNode, boolean[] visited){
        visited[currNode] = true;
        numNodes++;
        for(int neighbor: graph.get(currNode)){
            if(!visited[neighbor]){
                dfs(neighbor, visited);
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<connections.size(); i++){
            List<List<Integer>> newConnections = new ArrayList<>();
            int j=0;
            while(j<connections.size()){
                if(j!=i){
                    newConnections.add(connections.get(j));
                }
                j++;
            }
            buildGraph(n, newConnections);
            boolean[] visited = new boolean[n];
            dfs(i, visited);
            if(numNodes != n) result.add(connections.get(i));
            numNodes = 0;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("\n1192: Critical Connections In a Network ");
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        criticalConnections(4, connections);
    }
    
}
