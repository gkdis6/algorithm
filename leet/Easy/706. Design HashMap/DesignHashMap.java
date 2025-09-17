//https://leetcode.com/problems/design-hashmap/

class MyHashMap {
    private static int capacity = 10001;
    private Node[] buckets;

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap() {
        this.buckets = new Node[capacity];
    }

    private int hash(int key){
        return key % capacity;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        Node current = buckets[index];
        while(current != null){
            if(current.key == key) {
                current.value = value;
                return;
            }
            if(current.next == null) {
                current.next = new Node(key, value);
                return;
            }
            current = current.next;
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while(current != null){
            if(current.key == key){
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];

        if(current == null) {
            return;
        }

        if(current.key == key) {
            buckets[index] = current.next;
            return;
        }

        while(current.next != null) {
            if(current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
