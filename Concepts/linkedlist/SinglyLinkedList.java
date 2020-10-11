package concepts.linkedlist;

public class SinglyLinkedList<T> {
    public class Node{
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    // Constructor
    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    // Function to check whether the linked list is empty.
    public boolean isEmpty(){
        if(headNode == null){
            return true;
        }
        return false;
    }
    
    // Function to insert element at the end of the linked list.
    public void insertAtEnd(T data) {
        Node head = headNode;
        Node newNode = new Node();
        newNode.data = data;
        if(head == null){
            headNode = newNode;
            size++;
            return;
        }
        while(head.nextNode != null){
            head = head.nextNode;
        }
        head.nextNode = newNode;
        size++;
        return;
    }


    // Function to search for an element in the linked list.
    public boolean searchNode(T data) {
        Node head = headNode;
        if(head == null){
            return false;
        }
        while(head != null){
            if(data == head.data){
                return true;
            }
            head = head.nextNode;
        }
        return false; 
    }

    // Function to delete an element by its value.
    public void deleteByValue(T data) {
        Node prev = headNode;
        Node curr = headNode;

        if(data == headNode.data){
            headNode = headNode.nextNode;
        }

        while(curr != null){

            if(curr.data == data){
                prev.nextNode = curr.nextNode;
                size--;
                return;
            }
            prev = curr;
            curr = curr.nextNode;
        }
      }


    // Function to print the linked list elements
    public void printLinkedList(){
        Node head = headNode;
        while(head != null){
            System.out.println(head.data);
            head = head.nextNode;
        }
    }


    public static void main(String[] args){
        SinglyLinkedList<Integer> solution = new SinglyLinkedList<>();
        System.out.println(solution.isEmpty());
        solution.insertAtEnd(2);
        solution.insertAtEnd(3);
        solution.insertAtEnd(4);
        solution.printLinkedList();
        solution.deleteByValue(2);
        solution.printLinkedList();
    }
    
}
