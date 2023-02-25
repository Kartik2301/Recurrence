Solution 1 :- 
Brute force based
Like using an additional data structure like stack

Time complexity :- O(n)
Space complexity :- O(n) 

Solution 2 :-

O(1) space solution, by adjusting the links between the nodes

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        ListNode nex = dummy;
        int size = 0;
        while(cur.next != null) {
            cur = cur.next;
            size++;
        }
        while(size >= k) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1;i<k;i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            size -= k;
        }
        return dummy.next;
    }
}

Time complexity :- O(n)
Space complexity :- O(1) 