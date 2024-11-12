package LLDQuestions.HashMapImplementation;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = (1 << 4);
    private static final int MAXIMUM_CAPACITY = (1 << 30);
    private Entry<K, V> [] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        hashTable = new Entry[getNearestCapacityFor(capacity)];
    }

    class Entry<K, V> {
        private K key;
        private V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    private int getNearestCapacityFor(int capacity) {
        int n = capacity;
        assert(n > 0);

        if((n & (n - 1)) == 0) {
            return n;
        }

        n = n | (n >> 1);
        n = n | (n >> 2);
        n = n | (n >> 4);
        n = n | (n >> 8);
        n = n | (n >> 16);

        return n + 1;
    }

    public void put(K key, V value) {
        int hashValue = ((key.hashCode() % hashTable.length) + hashTable.length - 1) % hashTable.length;
        Entry<K,V> node = hashTable[hashValue];

        if(node == null) {
            hashTable[hashValue] = new Entry<>(key, value);
        } else {
            Entry<K, V> lastNode = node;
            while(lastNode.next != null) {
                if(lastNode.getKey() == key) {
                    lastNode.setValue(value);
                    return;
                }
                lastNode = lastNode.next;
            }
            lastNode.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int hashValue = ((key.hashCode() % hashTable.length) + hashTable.length - 1) % hashTable.length;
        Entry<K,V> node = hashTable[hashValue];

        while(node != null) {
            if(node.getKey() == key) {
                return node.getValue();
            }
        }

        return null;
    }

}
