
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MergekSortedLists {

    public static void printLinkedList(ListNode head){
        ListNode curr  = head;
        System.out.println("\nContents of the Linked List: ");
        while(curr!=null){
            System.out.print(curr.val  + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        ListNode dummyhead = dummy;

        for(ListNode list: lists){
            if(list != null){
                pq.offer(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode popped = pq.poll();
            dummy.next = new ListNode(popped.val);
            dummy = dummy.next;
            if(popped.next != null){
                pq.offer(popped.next);
            }
        }
        return dummyhead.next;
    }
    public static void main(String[] args){
        System.out.println("\n 23. Merge k Sorted Lists");
        ListNode firstList = new ListNode(1);
        firstList.next = new ListNode(4);
        firstList.next.next = new ListNode(5);

        ListNode secondList = new ListNode(1);
        secondList.next = new ListNode(3);
        secondList.next.next = new ListNode(4);

        ListNode thirdList = new ListNode(2);
        thirdList.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{firstList, secondList, thirdList};
        printLinkedList(mergeKLists(lists));
    }
    
}
