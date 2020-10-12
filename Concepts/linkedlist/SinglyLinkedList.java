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


    //Detects loop in the given linked list
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node hare = list.headNode;
        SinglyLinkedList<T>.Node turtle = list.headNode;

        while(turtle!=null && hare!=null){
            turtle = turtle.nextNode;

            // move the hare by 2 steps if possible.
            hare = hare.nextNode;
            if(hare == null){
                return false;
            }
            else{
                hare = hare.nextNode;
            }

            if(hare == turtle){
                return true;
            }

        }


        return false;
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node hare = list.headNode;
        SinglyLinkedList<T>.Node turtle = list.headNode;
        if(turtle == null){
            return null;
        }

        if(turtle.nextNode == null){
            return turtle.data;
        }

        

        while(hare!=null && hare.nextNode!=null){
            hare = hare.nextNode.nextNode;
            if(hare != null){
                turtle = turtle.nextNode;
            }
        }


        return turtle.data;
        // 122 -> 11 -> 8 -> 5 -> 2 -> 90 -> null
        // 122 | 8
        // 11 | 2
        // 8 | 
    }

    public static void main(String[] args){
        SinglyLinkedList<Integer> solution = new SinglyLinkedList<>();
        System.out.println(solution.isEmpty());
        solution.insertAtEnd(22);
        solution.insertAtEnd(21);
        solution.insertAtEnd(10);
        solution.insertAtEnd(14);
        solution.insertAtEnd(7);
        System.out.println(findMiddle(solution));
    }
    
}
