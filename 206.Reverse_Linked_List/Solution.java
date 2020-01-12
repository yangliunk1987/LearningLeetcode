/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead;
        if (head == null || head.next == null) {
            return head;
        }
        newHead = reverseList(head.next); // head.next 作为剩余部分的头指针
        // head.next 代表新链表的尾，将它的 next 置为 head，就是将 head 加到末尾了。
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}