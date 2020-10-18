# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        nex = None
        curr = head
        while(curr != None):
            nex = curr.next
            curr.next = prev
            prev = curr
            curr = nex
    
        head = prev
        return head

    def printLinkedList(self, head: ListNode) -> ListNode:
        ptr = head
        while(ptr != None):
            print(ptr.val)
            ptr = ptr.next


head = ListNode(2)
head.next = ListNode(3)
head.next.next = ListNode(4)
s = Solution()
# s.printLinkedList(head)
print(s.printLinkedList(s.reverseList(head)))



        