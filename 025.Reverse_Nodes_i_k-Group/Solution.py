class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        def reverseLinkedList(node):
            prev, curr = None, node
            while curr is not None:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            return prev, node
        
        def getKNodes(node, k):
            curr = node
            while k > 1 and curr is not None:
                k -= 1
                curr = curr.next
            if curr is None:
                return False, curr
            return True, curr
        
        if k < 2:
            return head
        nh = ListNode(None)
        nh.next = head
        curr = nh
        while curr is not None:
            part_head = curr.next
            can_take, part_tail = getKNodes(part_head, k)
            if not can_take:
                break
            next_head = part_tail.next
            part_tail.next = None
            rh, rt = reverseLinkedList(part_head)
            curr.next = rh
            curr = rt
            curr.next = next_head
        return nh.next
