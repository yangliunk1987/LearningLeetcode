/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tailA = headA;
        int lenA = 0;
        //链表 A 的长度
        while (tailA.next != null) {
            tailA = tailA.next;
            lenA++;
        }
        ListNode tailB = headB;
        int lenB = 0;
        //链表 B 的长度
        while (tailB.next != null) {
            tailB = tailB.next;
            lenB++;
        }
        //没有重合部分，直接结束
        if (tailA != tailB) {
            return null;
        }
        //让长的链表提前走
        if (lenA > lenB) {
            int sub = lenA - lenB;
            while (sub > 0) {
                headA = headA.next;
                sub--;
            }
        } else {
            int sub = lenB - lenA;
            while (sub > 0) {
                headB = headB.next;
                sub--;
            }
        }

        //依次遍历，找到相遇点
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}