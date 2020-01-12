# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        # iteratively
        if root is None:
            return None
        queue = [root]
        while len(queue):
            curr = queue.pop(0)
            curr.left, curr.right = curr.right, curr.left
            if curr.left is not None:
                queue.append(curr.left)
            if curr.right is not None:
                queue.append(curr.right)
        return root