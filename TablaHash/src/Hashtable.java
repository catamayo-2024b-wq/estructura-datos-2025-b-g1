// HashTable.java
public class HashTable<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = Math.max(4, capacity);
        this.buckets = (Entry<K, V>[]) new Entry[this.capacity];
        this.size = 0;
    }

    public HashTable() {
        this(16);
    }

    private int indexFor(Object key) {
        if (key == null) return 0;
        int h = key.hashCode();
        return (h & 0x7FFFFFFF) % capacity;
    }

    // put: insertar o actualizar; devuelve el valor antiguo o null
    public V put(K key, V value) {
        int idx = indexFor(key);
        Entry<K, V> head = buckets[idx];

        for (Entry<K, V> cur = head; cur != null; cur = cur.next) {
            if ((key == null && cur.key == null) || (key != null && key.equals(cur.key))) {
                V old = cur.value;
                cur.value = value;
                return old;
            }
        }

        buckets[idx] = new Entry<>(key, value, head);
        size++;
        return null;
    }

    // get: devuelve valor o null
    public V get(K key) {
        int idx = indexFor(key);
        for (Entry<K, V> cur = buckets[idx]; cur != null; cur = cur.next) {
            if ((key == null && cur.key == null) || (key != null && key.equals(cur.key))) {
                return cur.value;
            }
        }
        return null;
    }

    // remove: elimina y devuelve valor (o null si no existe)
    public V remove(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];
        Entry<K, V> prev = null;
        while (cur != null) {
            if ((key == null && cur.key == null) || (key != null && key.equals(cur.key))) {
                if (prev == null) {
                    buckets[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    // containsKey
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // size e isEmpty
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // método opcional para debugging: imprime cada cubeta
    public void debugPrintBuckets() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("bucket[" + i + "]: ");
            Entry<K, V> cur = buckets[i];
            while (cur != null) {
                System.out.print("{" + cur.key + ":" + cur.value + "} -> ");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }
}
