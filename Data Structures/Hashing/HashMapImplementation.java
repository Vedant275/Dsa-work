import java.util.*;

public class HaspMapCode {
    public static class LinkedList<T> {
        private class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;

        public LinkedList() {
            this.head = null;
        }

        public void addLast(T data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
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
            while (current != null) {
                count++;
                current = current.next;
            }
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

    public static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N;
        }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) return i;
            }
            return -1;
        }

        public void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N *= 2;
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
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
                Node data = buckets[bucketIndex].get(dataIndex);
                data.value = value;
            }

            if ((double) n / N > 2.0) rehash();
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex == -1) return null;
            return buckets[bucketIndex].get(dataIndex).value;
        }

        public boolean containsKey(K key) {
            return get(key) != null;
        }

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
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> Map = new HashMap<>();
        Map.put("India", 190);
        Map.put("China", 200);
        Map.put("USA", 50);

        ArrayList<String> keys = Map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + Map.get(keys.get(i)));
        }

        Map.remove("India");
        System.out.println("India removed");
    }
}
