import java.util.*;
class Node{
    int key; 
    int val;
    int count;
    Node(int key, int val, int count){
        this.key = key;
        this.val = val;
        this.count = count;
    }

}

public class LFUCache {

    static int minCount;
    static Map<Integer, Node> keyToNodeMapping;
    static Map<Integer, LinkedList<Node>> freqNodes;
    static int capacity = 3;



    public static int key(int key){
        if(!keyToNodeMapping.containsKey(key)){
            return -1;
        }

        return keyToNodeMapping.get(key).val;
    }

    public static void put(int key, int value) {
        if(keyToNodeMapping.size() + 1 > capacity){
            removeLFU();
        }
        if(!keyToNodeMapping.containsKey(key)){
            Node newNode = new Node(key, value, 0);
            keyToNodeMapping.put(key, newNode);
            minCount = 1;
            update(key);
        }
        else{
            Node newNode = keyToNodeMapping.get(key);
            newNode.val = value;
            keyToNodeMapping.put(key, newNode);
            update(key);
        }
    }

    public static void printlist(){
        for(Map.Entry<Integer, LinkedList<Node>> entry: freqNodes.entrySet()){
            System.out.print("Frequency " + entry.getKey() + " - ");
            for(Node n: entry.getValue()){
                System.out.print(n.key+","+n.val + "  ");
            }
            System.out.println();
        }

    }

    public static void removeLFU(){
        LinkedList<Node> ns = freqNodes.get(minCount);
        Node n = ns.remove(ns.size()-1);
        keyToNodeMapping.remove(n.key);

        if(ns.isEmpty()){
            freqNodes.remove(minCount);
        }
        else{
            freqNodes.put(minCount, ns);
        }

    }

    public static void update(int key){

        Node nodeToUpdate = keyToNodeMapping.get(key);

        if(nodeToUpdate.count == 0){
            minCount = 1;
            nodeToUpdate.count = nodeToUpdate.count +1;
            if(!freqNodes.containsKey(nodeToUpdate.count)){
                freqNodes.put(nodeToUpdate.count, new LinkedList<>());
            }
            freqNodes.get(nodeToUpdate.count).push(nodeToUpdate);
        }
        else{
            LinkedList<Node> frequencyNodes = freqNodes.get(nodeToUpdate.count);
            frequencyNodes.remove(nodeToUpdate);

            if(frequencyNodes.isEmpty()){

                freqNodes.remove(nodeToUpdate.count);

                if(minCount == nodeToUpdate.count){
                    minCount = nodeToUpdate.count+1;
                }
            }
            
            nodeToUpdate.count = nodeToUpdate.count +1;
            if(!freqNodes.containsKey(nodeToUpdate.count)){
                freqNodes.put(nodeToUpdate.count, new LinkedList<>());
            }
            freqNodes.get(nodeToUpdate.count).push(nodeToUpdate);
        }

    }


    
    public static void main(String[] args){
        System.out.println("\n460. LFU Cache");
        keyToNodeMapping = new HashMap<>();
        freqNodes = new HashMap<>();
        minCount = 1;
        freqNodes.put(1, new LinkedList<>());
    
        put(1,1);
        put(2,2);
        put(3,3);
        put(4,4);
        put(5,5);
        printlist();

    }
    
}
