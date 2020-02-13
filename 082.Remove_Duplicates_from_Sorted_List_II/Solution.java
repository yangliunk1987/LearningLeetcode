/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        //如果头结点和后边的节点相等
        if (head.next != null && head.val == head.next.val) {
            //跳过所有重复数字
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //将所有重复数字去掉后，进入递归
            return deleteDuplicates(head.next);
        //头结点和后边的节点不相等
        } else {
            //保留头结点，后边的所有节点进入递归
            head.next = deleteDuplicates(head.next);
        }
        //返回头结点
        return head;
    }
}