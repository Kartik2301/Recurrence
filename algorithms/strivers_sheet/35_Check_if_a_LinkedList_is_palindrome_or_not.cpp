Solution 1 :-
Brute force based which require O(n) space

Like using an additional data structure or create the reverse linked list.

Time complexity :- O(n)

Solution 2 :-

Use tortoise and hare method to find the middle point, and then reverse the list after that midpoint, and compare the first part and 
the modified second part of the linked list

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode begin = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        while(begin != null && prev != null){
            if(begin.val != prev.val) return false;
            begin = begin.next;
            prev = prev.next;
        }
        return true;
    }
}

Time complexity :- O(n)
Space complexity :- O(1)