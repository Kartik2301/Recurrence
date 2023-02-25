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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        if(head == null || head.next == null || k == 0) return head;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        k %= size;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        if(k == 0) return dummy.next;
        k = size-k;
        while(k > 0) {
            temp = temp.next;
            k--;
        } 
        
        ListNode new_head = temp.next;
        ListNode copy = temp.next;
        temp.next = null;
        while(new_head.next != null) {
            new_head = new_head.next;
        }
        new_head.next = dummy.next;
        dummy.next = copy;
        return dummy.next;
    }
}

Time Complexity :- O(n)
Space Complexity :- O(1)


Solution 2 :-
Time Complexity :- O(n)
Space Complexity :- O(n) [using an additional ds or create a new linked list]