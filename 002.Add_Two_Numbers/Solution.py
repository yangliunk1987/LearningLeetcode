class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        new_head = None
        curr1, curr2 = l1, l2
        prev, curr = None, None
        while curr1 is not None or curr2 is not None:
            val1, val2 = 0, 0
            if curr1 is not None:
                val1 = curr1.val
                curr1 = curr1.next
            if curr2 is not None:
                val2 = curr2.val
                curr2 = curr2.next
            carry, val = divmod(val1 + val2 + carry, 10)
            curr = ListNode(val)
            if prev is not None:
                prev.next = curr
            if new_head is None:
                new_head = curr
            prev = curr
        if carry > 0:
            curr = ListNode(carry)
            if prev:
                prev.next = curr
        return new_head