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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorderTraversal(p,q);
    }
    private boolean inorderTraversal(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }
        //考虑左子树是否符合
        if(!inorderTraversal(p.left,q.left)){
            return false;
        }
        //考虑当前节点是否符合
        if(p.val!=q.val){
            return false;
        }
        //考虑右子树是否符合
        if(!inorderTraversal(p.right,q.right)){
            return false;
        }
        return true;
    }
}