Solution 1 :-

Time complexity :- O(n*m)
Space complexity :- O(1)

class GfG {
    Node flatten(Node root) {
        Node result = root;
        Node cur = root;
        cur = cur.next;
        while(cur != null) {
            result = merge(result, cur);
            cur = cur.next;
        }
        return result;
    }
    Node merge(Node a, Node b) {
        if(a == null && b == null) return null;
        if(a == null) return b;
        if(b == null) return a;
        Node result = null;
        if(a.data < b.data) {
            result = a;
            a.bottom = merge(a.bottom,b);
        } else {
            result = b;
            b.bottom = merge(a,b.bottom);
        }
        return result;
    }
}

Solution 2 :-
Use some additional data structure or construct a new list after merging
Time complexity :- O(n)
Space complexity :- O(1)