Solution 1 :-
Brute Force Solution
Time complexity :- O(m*n)
Space complexity :- O(1)

Solution 2 :-
Use a hash set
Time complexity :- O(m+n)
Space complexity :- O(m+n)

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
        Set<ListNode> set = new HashSet<>();
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            if(set.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    } 
}

Solution 3 :-
Equalize both lengths by skipping some starting nodes in the bigger list
Time complexity :- O(m+n)
Space complexity :- O(1)

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
        if(headA == null || headB == null) return null;
        ListNode smaller, bigger;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int size1 = 0;
        int size2 = 0;
        while(temp1 != null) {
            size1++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null) {
            size2++;
            temp2 = temp2.next;
        }
        bigger = (size1 > size2) ? headA : headB;
        smaller = (size1 > size2) ? headB : headA;
        int diff = Math.abs(size1 - size2);
        while(diff > 0) {
            bigger = bigger.next;
            diff--;
        }
        while(smaller != null && bigger != null) {
            if(smaller == bigger) {
                return smaller;
            }
            smaller = smaller.next;
            bigger = bigger.next;
        }
        return null;
    }
}