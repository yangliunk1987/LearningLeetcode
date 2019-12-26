public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head.next;
        ListNode temp = first.next;
        head.next = temp;
        first.next = head;
        ListNode prev = first;
        ListNode curr = first.next;
        int num = 1;
        while (prev != null && curr != null) {
            if (num % 2 == 0) {
                if (curr.next != null) {
                    temp = curr.next;
                    curr.next = temp.next;
                    temp.next = curr;
                    prev.next = temp;
                    curr = temp;
                } else {
                    break;
                }
            }
            prev = prev.next;
            curr = curr.next;
            num++;
        }
        
        return first;
    }
}
