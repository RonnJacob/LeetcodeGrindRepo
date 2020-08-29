
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class AllNodesDistanceKInBinaryTree {

    public static void addEdges(int src, int dest, Map<Integer, List<Integer>> neighbors){
        if(neighbors.containsKey(src)){
            List<Integer> retrievedNeighbors = neighbors.get(src);
            retrievedNeighbors.add(dest);
            neighbors.put(src, retrievedNeighbors);
        }
        else{

            List<Integer> retrievedNeighbors = new ArrayList<>();
            retrievedNeighbors.add(dest);
            neighbors.put(src, retrievedNeighbors);

        }

        if(neighbors.containsKey(dest)){
            List<Integer> retrievedNeighbors = neighbors.get(dest);
            retrievedNeighbors.add(src);
            neighbors.put(dest, retrievedNeighbors);
        }
        else{

            List<Integer> retrievedNeighbors = new ArrayList<>();
            retrievedNeighbors.add(src);
            neighbors.put(dest, retrievedNeighbors);
        }
    }

    public static void createGraph(TreeNode root, Map<Integer, List<Integer>> neighbors, Map<Integer, Boolean> visited){
        if(root == null){
            return;
        }

        if(root.left != null){
            addEdges(root.val, root.left.val, neighbors);
        }

        if(root.right != null){
            addEdges(root.val, root.right.val, neighbors);
        }

        createGraph(root.left, neighbors, visited);
        createGraph(root.right, neighbors, visited);
        visited.put(root.val, false);

    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        
        createGraph(root, neighbors, visited);

        
        List<Integer> result = new ArrayList<>();
        DFS(neighbors, target.val, 0, K, visited, result);
        return result;
    }
    
    public static void DFS(Map<Integer, List<Integer>> graph, int source, int level, int target, Map<Integer, Boolean> visited, List<Integer> result){
        if(level > target || visited.get(source) == true){
            return;
        }

        if(!graph.containsKey(source)){
            return;
        }

        if(level == target){
            result.add(source);
        }


        visited.put(source, true);

        List<Integer> neighbors = graph.get(source);
        for(Integer d: neighbors){
            DFS(graph, d, level+1, target, visited, result);
        }

        
    }
    public static void main(String[] args){
        System.out.println("\n863. All Nodes Distance K in Binary Tree\n");
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(5);
        int K = 2;

        TreeNode target = n.left;
        n.left.left = new TreeNode(6);
        n.left.right = new TreeNode(2);
        n.left.right.left = new TreeNode(7);
        n.left.right.right = new TreeNode(4);

        n.right = new TreeNode(1);
        n.right.left = new TreeNode(0);
        n.right.right = new TreeNode(8);

        System.out.println("All Nodes in Binary Tree of Distance " + K + " from " + target.val + " are ");
        System.out.println(distanceK(n, target, K).toString());

    }
    
}