Solution 1 :-

Approach: Swap with Next Node [Accepted]
The usual way of deleting a node node from a linked list is to modify the next pointer of the node before it, 
to point to the node after it.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int value = node.next.val;
        node.val = value;
        node.next = node.next.next;
    }
}

Time and space complexity are both O(1)