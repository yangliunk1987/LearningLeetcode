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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        Stack<TreeNode> roots = new Stack<TreeNode>();
        int post = postorder.length - 1;
        int in = inorder.length - 1;
        TreeNode curRoot = new TreeNode(postorder[post]);
        TreeNode root = curRoot;
        roots.push(curRoot);
        post--;
        while (post >=  0) {
            if (curRoot.val == inorder[in]) {
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    curRoot = roots.peek();
                    roots.pop();
                    in--;
                }
                curRoot.left = new TreeNode(postorder[post]);
                curRoot = curRoot.left;
                roots.push(curRoot);
                post--;
            } else {
                curRoot.right = new TreeNode(postorder[post]);
                curRoot = curRoot.right;
                roots.push(curRoot);
                post--;
            }
        }
        return root;
    }
}