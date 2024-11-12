package HashMapImplementation;


public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = (1 << 4);
    private static final int MAXIMUM_CAPACITY = (1 << 30);
    
    public Entry<K, V> [] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity) {
        hashTable = new Entry[getNearestValidCapacity(capacity)];
    }

    public int getNearestValidCapacity(int capacity) {
        int n = capacity;

        if(n <= 0) {
            AssertionError assertionError = new AssertionError("The hash map should have a positive capacity");
            throw assertionError;
        }

        if(n >= MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }

        if((n & (n - 1)) == 0) {
            return n;
        }

        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);

        return n + 1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K,V> node = hashTable[hashCode];

        if(node == null) {
            hashTable[hashCode] = new Entry<K,V>(key, value);
        } else {
            Entry<K, V> prevNode = null;
            Entry<K, V> curNode = node;
            while (curNode != null) {
                if(curNode.key == key) {
                    curNode.value = value;
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode.next = new Entry<K,V>(key, value); 
        }
    }

    public V get(K key) {
        Entry<K, V> node = hashTable[key.hashCode() % hashTable.length];
        if(node == null) {
            return null;
        }

        Entry<K, V> curNode = node;
        while (curNode != null) {
            if(curNode.key == key) {
                return curNode.value;
            }

            curNode = curNode.next;
        }

        return null;
    }

    class Entry <K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main (String [] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "Niggamma Pur");
        hashMap.put(2, "Peephole");
        hashMap.put(3, "Jordan Hermann");
        hashMap.put(4, "Fartout Yuki");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(4));
    }

}
