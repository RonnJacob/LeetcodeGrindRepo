package blind;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReorderList {

    public static void printLinkedList(ListNode head){
        ListNode curr  = head;
        System.out.println("\nContents of the Linked List: ");
        while(curr!=null){
            System.out.print(curr.val  + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public static ListNode getMiddle(ListNode head){
        ListNode turtle = head;
        ListNode hare = head;

        
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }

    // Function to reverse the linked list.
    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = head;

        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head;
    }

    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode middleElement = reverseLinkedList(getMiddle(head));
        ListNode s_ptr = middleElement;
        ListNode f_ptr = head;
        while(s_ptr.next!=null){
            ListNode f_next = f_ptr.next;
            f_ptr.next = s_ptr;
            f_ptr = f_next;

            ListNode s_next = s_ptr.next;
            s_ptr.next  = f_ptr;
            s_ptr = s_next;
        }

        printLinkedList(head);

    }

    public static void main(String[] args){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next  = fourth;
        fourth.next  = fifth;
        
        reorderList(first);
    }

    
}
