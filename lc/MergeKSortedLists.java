import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        for(ListNode n: lists){
            if(n != null){
                pq.offer(n);
            }
        }

        ListNode pointer = new ListNode(0);
        ListNode res = pointer;

        while(!pq.isEmpty()){
            ListNode poppedNode = pq.poll();
            pointer.next = new ListNode(poppedNode.val);
            pointer = pointer.next;
            if(poppedNode.next != null){
                pq.offer(poppedNode.next);
            }
            
        }
        return res.next;
    }

    public static void printMergedList(ListNode head){
        System.out.println("\n Merged List Nodes");
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("\n23. Merge k Sorted Lists");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        printMergedList(mergeKLists(lists));
    }
    
}
