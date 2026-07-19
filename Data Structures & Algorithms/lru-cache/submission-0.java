class LRUCache {

    class Node{
        int val;
        int key;
        Node next;
        Node prev;

        public Node(){
        }

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

        public Node(int key, int val, Node next, Node prev){
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0); //least recently used
        this.right = new Node(0, 0); //most recently used
        this.left.next = right;
        this.right.prev = left;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            delete(cache.get(key));
        }
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
        if(cache.size() > capacity){
            Node lru = left.next;
            delete(lru);
            cache.remove(lru.key);
        }
    }
}
