package blind;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        HashMap<Node, Node> mp = new HashMap<>();


        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        mp.put(node, new Node(node.val, new ArrayList<>()));

        while(!queue.isEmpty()){
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor: n.neighbors) {
                if(!mp.containsKey(neighbor)){
                    mp.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }

                mp.get(n).neighbors.add(mp.get(neighbor));
            }
        }


        return mp.get(node);
    }


    

    


    public static void main(String[] args){
        System.out.println("\n 133. Clone Graph");
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);

        firstNode.neighbors = Arrays.asList(secondNode, fourthNode);
        secondNode.neighbors = Arrays.asList(firstNode, thirdNode);
        thirdNode.neighbors = Arrays.asList(secondNode, fourthNode);
        fourthNode.neighbors  = Arrays.asList(firstNode, thirdNode);
    }
    
}
