class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryOver = 0;
        ListNode l3 = new ListNode(0);
        ListNode resNode = l3;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carryOver;
            int result = sum;
            
            if(sum >= 10){
                result = sum % 10;
                carryOver = 1;
            }
            else{
                carryOver = 0;
            }
            resNode.next = new ListNode(result);

            l1 = l1.next;
            l2 = l2.next;
            resNode = resNode.next;
        }

        while(l1 != null){
            int sum = l1.val + carryOver;
            int result = sum;
            
            if(sum >= 10){
                result = sum % 10;
                carryOver = 1;
            }
            else{
                carryOver = 0;
            }
            System.out.print(result + " ");

            resNode.next = new ListNode(result);
            resNode = resNode.next;

            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carryOver;
            int result = sum;
            
            if(sum >= 10){
                result = sum % 10;
                carryOver = 1;
            }
            else{
                carryOver = 0;
            }
            resNode.next = new ListNode(result);
            resNode = resNode.next;
            l2 = l2.next;
        }

        if(carryOver>0){
            resNode.next = new ListNode(carryOver);
        }
        return l3.next;
    }


    public static void printListNodes(ListNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        printListNodes(root.next);
    }
    public static void main(String[] args){
        System.out.println("\n2. Add Two Numbers\n");
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        printListNodes(l1);
        System.out.println();

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printListNodes(l2);
        System.out.println();

        ;
        printListNodes(addTwoNumbers(l1, l2));
        System.out.println();
    }
    
}