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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<TreeNode> toVisit = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curSum = 0; // 记录当前的累计的和
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                curSum += cur.val;
                /************修改的地方******************/
                temp.add(cur.val);
                /**************************************/
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            // 判断是否满足条件
            if (curSum == sum && cur.left == null && cur.right == null) {
                /************修改的地方******************/
                ans.add(new ArrayList<>(temp));
                /**************************************/
            }
            // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                TreeNode pop = toVisit.pop();
                curSum -= pop.val; // 减去出栈的值
                /************修改的地方******************/
                temp.remove(temp.size() - 1);
                /**************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return ans;
    }
}