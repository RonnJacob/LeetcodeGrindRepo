import java.util.*;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    static Map<Node, Node> oldToNewNodes = new HashMap<>();
    public static Node getClonedNode(Node n){

        // If the node that you want to clone is a null.
        //      - then you return null.
        // IF the node that you want to clone isn't null
        //    - 1. if the node is already visited, return that node
        //    - 2. otherwise, you create a new node and return it with next and random as null.
        if(n!=null){
            if(oldToNewNodes.containsKey(n)){
                return oldToNewNodes.get(n);
            }
            else{
                oldToNewNodes.put(n, new Node(n.val));
                return oldToNewNodes.get(n);
            }
        }   
        return null;
    }
    public static Node copyRandomList(Node head) {

        if(head == null){
            return head;
        }

        Node newHead = new Node(head.val);
        Node oldHead = head;
        oldToNewNodes.put(oldHead, newHead);

        while(oldHead != null){
            newHead.next = getClonedNode(oldHead.next);
            newHead.random = getClonedNode(oldHead.random);
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return oldToNewNodes.get(head);   
    }

 
    public static void main(String[] args){
        System.out.println("\n138. Copy List with Random Pointer");
        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        first.random = null;
        second.random = first;
        third.random = fifth;
        fourth.random = third;
        fifth.random = first;

        copyRandomList(first);

    }
    
}
