package blind;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveNthNodeFromEndOfList {

    public static void printLinkedList(ListNode head){
        ListNode curr  = head;
        System.out.println("\nContents of the Linked List: ");
        while(curr!=null){
            System.out.print(curr.val  + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode ptr = head;
        int length = 0;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }

        int counter = length-n-1;
        
        if(n == length){
            head = head.next;
            return head;
        }

        if(counter < 0){
            return head;
        }
        ptr = head;
        while(counter > 0){
            counter--;
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        System.out.println(ptr.val);
        return head;
    }
    public static void main(String[] args){
        System.out.println("\n 19. Remove Nth Node From End of List");
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        first.next = second;
        // second.next = third;
        // third.next  = fourth;
        // fourth.next  = fifth;
        
        printLinkedList(removeNthFromEnd(first, 1));
        

    }
    
}
