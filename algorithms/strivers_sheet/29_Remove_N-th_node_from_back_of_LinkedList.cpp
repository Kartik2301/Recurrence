Solution 1 :- 2 pass algorithm
Intuition

We notice that the problem could be simply reduced to another one : Remove 
the (L - n + 1)th node from the beginning in the list , 
where LL is the list length. This problem is easy to solve once we found list length LL.

Algorithm

First we will add an auxiliary "dummy" node, which points to the list head. 
The "dummy" node is used to simplify some corner cases such as a list with only one node, 
or removing the head of the list. On the first pass, we find the list length LL. 
Then we set a pointer to the dummy node and start to move it through the list till it comes to the (L−n) th node. 
We relink next pointer of the (L−n) th node to the (L−n+2) th node and we are done.

Time complexity : O(L)
Space complexity : O(1)


Solution 2 :- One pass solution

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=1;i<=n;i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            count++;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

Time complexity : O(L)
Space complexity : O(1).