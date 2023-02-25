Solution 1 :- Use hash map 

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}


Time complexity :- O(n)
Space complexity :- O(1)

Solution 2 :- 

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        while(iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        iter = head;
        while(iter != null) {
            if(iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while(iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            copy = copy.next;
            
            iter.next = front;
            iter = front;
        }
        return dummy.next;
    }
}

Time complexity :- O(n)
Space complexity :- O(1)
