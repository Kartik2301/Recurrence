Solutions 1 :-

Basic solutions like using array. Or compute the size (2 passes)
Time Comlexity :- O(n)
Space Comlexity :- O(1) or O(n)

Solution 2 :- Using slow and fast pointers

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
When traversing the list with a pointer slow, make another pointer fast that traverses 
twice as fast. When fast reaches the end of the list, slow must be in the middle.

Time Complexity: O(N)
Space Complexity: O(1)
