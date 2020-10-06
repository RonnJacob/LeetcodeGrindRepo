class NodeS{
    NodeS next;
    int data;
    public NodeS(int val){
        this.data = val;
    }

    public void appendToTail(int d){
        NodeS end = new NodeS(d);
        NodeS n = this;
        while(n.next!= null){
            n = n.next;
        }
        n.next = end;
    }

    public void printLinkedList(){
        NodeS n = this;
        System.out.println();
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

}
public class LinkedListCTCI {
    public static void main(String[] args){
        System.out.println("\nLinked List CTCI\n");
        NodeS head = new NodeS(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.printLinkedList();
    }
}
