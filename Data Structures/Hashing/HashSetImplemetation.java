import java.util.ArrayList;

public class Main {

    // Generic LinkedList class
    static class LinkedList<T> {
        private class Node {
            T data;
            Node next;
            Node(T data) { this.data = data; this.next = null; }
        }

        private Node head;

        public LinkedList() { head = null; }

        public void addLast(T data) {
            Node newNode = new Node(data);
            if (head == null) { head = newNode; return; }
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }

        public T get(int index) {
            Node current = head;
            int i = 0;
            while (current != null) {
                if (i == index) return current.data;
                current = current.next;
                i++;
            }
            return null;
        }

        public int size() {
            Node current = head;
            int count = 0;
            while (current != null) { count++; current = current.next; }
            return count;
        }

        public T remove(int index) {
            if (head == null) return null;
            if (index == 0) {
                T val = head.data;
                head = head.next;
                return val;
            }
            Node current = head;
            int i = 0;
            while (current != null && i < index - 1) {
                current = current.next;
                i++;
            }
            if (current == null || current.next == null) return null;
            T val = current.next.data;
            current.next = current.next.next;
            return val;
        }
    }

    // Custom HashMap
    static class MyHashMap<K, V> {
        private class Node {
            K key;
            V value;
            Node(K key, V value) { this.key = key; this.value = value; }
        }

        private LinkedList<Node>[] buckets;
        private int N = 4;  // initial bucket size
        private int n = 0;  // total number of elements

        @SuppressWarnings("unchecked")
        public MyHashMap() {
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) buckets[i] = new LinkedList<>();
        }

        private int hashFunction(K key) { return Math.abs(key.hashCode()) % N; }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) return i;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N *= 2;
            @SuppressWarnings("unchecked")
            LinkedList<Node>[] newBuckets = new LinkedList[N];
            for (int i = 0; i < N; i++) newBuckets[i] = new LinkedList<>();
            buckets = newBuckets;
            n = 0;

            for (LinkedList<Node> ll : oldBuckets) {
                for (int i = 0; i < ll.size(); i++) {
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex == -1) {
                buckets[bucketIndex].addLast(new Node(key, value));
                n++;
            } else {
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            if ((double)n / N > 2.0) rehash();
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex == -1) return null;
            return buckets[bucketIndex].get(dataIndex).value;
        }

        public boolean containsKey(K key) { return get(key) != null; }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex == -1) return null;
            Node node = buckets[bucketIndex].remove(dataIndex);
            n--;
            return node.value;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (int i = 0; i < ll.size(); i++) {
                    keys.add(ll.get(i).key);
                }
            }
            return keys;
        }

        public boolean isEmpty() { return n == 0; }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        System.out.println("Value for B: " + map.get("B")); // 20
        System.out.println("Contains C? " + map.containsKey("C")); // true

        map.remove("B");
        System.out.println("Contains B? " + map.containsKey("B")); // false

        System.out.println("All keys: " + map.keySet());
    }
}
