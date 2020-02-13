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
        if(head == null || head.next == null){
            return head;
        }
        //头结点和后一个时候相等
        if(head.val == head.next.val){
            //去掉头结点
            return deleteDuplicates(head.next);
        }else{
            //加上头结点
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}