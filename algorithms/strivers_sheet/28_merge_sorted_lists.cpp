Solution 1 :-
Use extra space 
Create a new list

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
    ListNode temp3 = null;
    ListNode tail = null;
    public void insend(int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = null;
        if(temp3 == null) {
            temp3 = new_node;
            tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
        return;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 != null && temp2 != null) {
            if(temp1.val < temp2.val) {
                insend(temp1.val);
                temp1 = temp1.next; 
            } else {
                insend(temp2.val);
                temp2 = temp2.next;
            }
        }
        while(temp1 != null) {
            insend(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            insend(temp2.val);
            temp2 = temp2.next;
        }
        return temp3;
    }
}

Time complexity :- O(m+n); m -> size of first list, n -> size of second list
Space complexity :- O(m+n)

Solution 2 :- 
Extra Space not allowed

(a) Recurssive Solution
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1,l2);
    }
    public ListNode merge(ListNode a, ListNode b) {
        if(a == null && b == null) return null;
        if(a == null) return b;
        if(b == null) return a;
        ListNode result = null;
        if(a.val < b.val) {
            result = a;
            a.next = merge(a.next,b);
        } else {
            result = b;
            b.next = merge(a,b.next);
        }
        return result;
    }
}

(b) Iterative Solution 


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        while(l1 != null && l2 != null) {
            ListNode tmp = null;
            while(l1 != null && l1.val <= l2.val) {
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;
    }
}



Time complexity :- O(m+n)
Space complexity :- O(1)