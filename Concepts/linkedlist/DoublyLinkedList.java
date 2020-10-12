package concepts.linkedlist;

public class DoublyLinkedList<T> {

    public class Node<T>{
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node<T> headNode;
    public Node<T> tailNode;
    public int size;

    public DoublyLinkedList(){
        this.headNode = null;
        this.tailNode = null;
        size = 0;
    }

    public int length(){
        int count = 0;
        Node<T> head = headNode;
        while(head != null){
            count++;
            head = head.nextNode;
        }
        return count;
    }

    public void reverseLinkedList(){
        Node<T> next = null;
        Node<T> prev = null;
        Node<T> curr = headNode;

        while(curr!=null){
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;

        }

        // Always update the head node because you want the starting pointer to be at the 
        // previous of the linked list traversal.
        headNode = prev;
    }

    public void insertAtHead(T data){
        Node<T> newNode = new Node<>();
        newNode.data = data;
        // Make next of new node as head and previous as NULL
        newNode.nextNode = this.headNode; 
        newNode.prevNode = null;
        //Change previous of head node to new node
        if (headNode != null)
            headNode.prevNode = newNode;
        this.headNode = newNode;
        size++;
    }

    public void printDoublyLinkedList(){
        Node<T> head = headNode;
        while(head != null){
            System.out.println(head.data);
            head = head.nextNode;
        }
    }


    public static void main(String[] args){
        System.out.println("\n Doubly Linked List");
        DoublyLinkedList<Integer> solution = new DoublyLinkedList<>();
        solution.insertAtHead(2);
        solution.insertAtHead(3);
        solution.printDoublyLinkedList();

    }
    
}
