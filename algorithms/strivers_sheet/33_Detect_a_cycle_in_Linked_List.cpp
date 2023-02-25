Solution 1 :-

Use a set 

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == NULL || k == 1) return head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode *pre = dummy;
        ListNode *nex = dummy;
        ListNode *cur = dummy;
        int size = 0;
        while(cur->next != NULL) {
            cur = cur->next;
            size++;
        }
        while(size >= k) {
            cur = pre->next;
            nex = cur->next;
            for(int i=1;i<k;i++) {
                cur->next = nex->next;
                nex->next = pre->next;
                pre->next = nex;
                nex = cur->next;
            }
            pre = cur;
            size -= k;
        }
        return dummy->next;
    }
};

Time complexity :- O(n)
Space complexity :- O(n)

Solution 2 :-

Use fast and slow pointers

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
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode nex = dummy;
        int i;
        int size = 0;
        while(cur.next != null) {
            cur = cur.next;
            size++;
        }
        while(size >= k) {
            cur = pre.next;
            nex = cur.next;
            for(i=1;i<k;i++) {
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