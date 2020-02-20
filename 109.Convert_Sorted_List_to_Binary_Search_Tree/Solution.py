# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        size = 0
        p = head
        while p:
            size += 1
            p = p.next

        def rebuildTree(l, r):
            nonlocal head
            if l >= r:
                return None
            
            mid = (l+r)//2

            left = rebuildTree(l, mid)
            root = TreeNode(head.val)
            root.left = left
            
            head = head.next

            root.right = rebuildTree(mid+1, r)

            return root
            
        return rebuildTree(0, size)