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
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curSum = 0; //记录当前的累计的和
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                curSum += cur.val;
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            //判断是否满足条件
            if (curSum == sum && cur.left == null && cur.right == null) {
                return true;
            }
            // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                TreeNode pop = toVisit.pop();
                curSum -= pop.val; //减去出栈的值
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return false;
    }
}