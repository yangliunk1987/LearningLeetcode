/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}