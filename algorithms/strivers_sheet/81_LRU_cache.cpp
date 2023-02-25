class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    int size = 0;
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void remove(Node node) {
        Node previous = node.prev;
        Node next = node.next;
        previous.next = next;
        next.prev = previous;
    }
    public void add(Node node) {
        Node head_next = head.next;
        node.next = head_next;
        head_next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public int get(int key) {
        Node get_node = map.get(key);
        if(get_node == null) return -1;
        int value = get_node.value;
        remove(get_node);
        add(get_node);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node get_node = map.get(key);
            remove(get_node);
            get_node.value = value;
            add(get_node);
        } else {
            Node new_node = new Node();
            new_node.value = value;
            new_node.key = key;
            if(map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            } 
            add(new_node);
            map.put(key,new_node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

Time complexity :- O(1)
Space complexity :- O(1)