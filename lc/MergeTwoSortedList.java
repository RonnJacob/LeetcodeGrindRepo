
// Always remember to go to the next pointer in the result too  - result = result.next in the while loops.

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode res = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        while(l1 != null){
            result.next = new ListNode(l1.val);
            result = result.next;
            l1 = l1.next;
        }

        while(l2 != null){
            result.next = new ListNode(l2.val);
            result = result.next;
            l2 = l2.next;
        }
        return res.next;
    }

    public static void printLinkedList(ListNode l1){
        if(l1 == null){
            return;
        }
        System.out.print(l1.val + " ");
        printLinkedList(l1.next);
    }


    public static void main(String[] args){

        System.out.println("\n21. Merge Two Sorted Lists");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        System.out.println("\nFirst Linked List");
        printLinkedList(l1);
        System.out.println();

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println("\nSecond Linked List");
        printLinkedList(l2);
        System.out.println();

        ListNode l3 = mergeTwoLists(l1, l2);

        System.out.println("\nMerged Linked List");
        printLinkedList(l3);
        System.out.println();
    }
}