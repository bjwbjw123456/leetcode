public class LRUCache {
    class Node{
        int val;
        int key;
        Node pre;
        Node next;
        public Node(int k, int value){
            val = value;
            key = k;
            pre = null;
            next = null;
        }
    }
    
    
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int cap;
    int size;
    
    
    private void moveToFront(int key) {
        Node node = map.get(key);
        Node p = node.pre;
        Node n = node.next;
        p.next = n;
        n.pre = p;
        
        Node hn = head.next;
        node.pre = head;
        node.next = hn;
        head.next = node;
        hn.pre = node;
    }
    
    private void addToFront(Node node) {
        Node hn = head.next;
        node.pre = head;
        node.next = hn;
        head.next = node;
        hn.pre = node;
    }
    
    
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        map = new HashMap<Integer,Node>();
        head = new Node(-1,-1);
        tail = new Node(-2,-2);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        } else {
            Node tmp = map.get(key);
            moveToFront(key);
            return tmp.val;
        }
    }
    
    public void set(int key, int value) {
        if (cap == 0) return;
        
        if (map.containsKey(key)){
            Node tmp = map.get(key);
            tmp.val = value;
            //map.put(key,tmp);
            moveToFront(key);
            return;
        }
        
        Node n = new Node(key,value);
        if(size<cap){
            map.put(key,n);
            addToFront(n);
            size++;
        } else {
            
            addToFront(n);
            Node de = tail.pre;
            map.remove(de.key);
            Node p = de.pre;
            p.next = tail;
            tail.pre = p;
            //System.out.println(de.key);
            map.put(key,n);
            
        }
    }
}