# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        curr1, curr2, curr, nh = l1, l2, None, None
        while curr1 is not None or curr2 is not None:
            if curr1 is None or (curr2 is not None and curr2.val < curr1.val):
                if curr:
                    curr.next = curr2
                curr = curr2
                curr2 = curr2.next
            else:
                if curr:
                    curr.next = curr1
                curr = curr1
                curr1 = curr1.next
            if nh is None:
                nh = curr
        return nh
