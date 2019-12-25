public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry(l1, l2, 0);
    }
    
    private ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        int num1 = (l1 == null) ? 0 : l1.val; 
        int num2 = (l2 == null) ? 0 : l2.val;
        ListNode next1 = (l1 == null) ? null : l1.next;
        ListNode next2 = (l2 == null) ? null : l2.next;
        int result = num1 + num2 + carry;
        carry = result / 10;
        result = result % 10;
        
        ListNode l = new ListNode(result);
        l.next = addTwoNumbersWithCarry(next1, next2, carry);
        return l;
    }
}