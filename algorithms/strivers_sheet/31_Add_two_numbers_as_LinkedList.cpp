Solution 1 :-

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode cur = dummy;
        int carry = 0;
        while((temp1 != null) || (temp2 != null)) {
            int sum = carry;
            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            if(sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}


Time complexity : O(max(m,n))

Space complexity : O(max(m,n))