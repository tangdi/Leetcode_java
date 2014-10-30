import java.util.HashMap;


public class LRUCacheImproved {
	
	private class Node{
		public int key;
		public int val;
		public Node prev;
		public Node last;
		
		public Node(int key, int val, Node prev, Node last){
			this.key = key;
			this.val = val;
			this.prev = prev;
			this.last = last;
		}
		
		@Override
		public String toString(){
			return "(" + key + "," + val + ")"; 
		} 
		
	}
    private final int capacity;
   
    public HashMap<Integer, Node> innerMap;
    public Node head;
    public Node tail;
  
    
    
    public LRUCacheImproved(int capacity) {
        this.capacity = capacity;
        innerMap = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public void printHeadTail(){
    	System.out.println( "head: " + head + ", tail:" + tail);
    }
    
    public void removeNode(Node node){
    	Node before = node.prev;
    	Node after = node.last;
    	Node cur = node;
    	
    	if(before != null){
    		before.last = after;
    	} else{
    		head = after;
    	}
    	
    	if(after != null){
    		after.prev = before;
    	} else{
    		tail = before;
    	}
    	
    }
    
    public void setHead(Node node){
    	node.last = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
 
		head = node;
		if (tail == null) {
			tail = node;
		}
    	
    }
    public int get(int key) {
        if(key <= 0){
            return -1;
        }
        
        if(! innerMap.containsKey(key)){
            return -1;
        }
        
        Node node = innerMap.get(key);
        removeNode(node);
        setHead(node);
        return node.val;
    }
    
    public void set(int key, int value) {
    	//System.out.println(keyIndexMap);
    	Node node;
    	
    	if(innerMap.containsKey(key)){
    		node = innerMap.get(key);
    		node.val = value;
    		 removeNode(node);
    	     setHead(node);
    		 if(node == head){
    	        	return;
    	        }
    	        
    	} else {
    		node = new Node(key, value, null, null);
    		innerMap.put(key,  node);
    		setHead(node);
    	}	
        
        if (innerMap.size() > capacity){
        	innerMap.remove((Integer)tail.key);
        	tail = tail.prev;
        	if(tail.last != null){
        		tail.last = null;
        	}
        	
        }
       // System.out.println(FIFO);
       
    }
    
    public static void main(String[] args){
    	LRUCacheImproved lru = new LRUCacheImproved(2);
    /*	lru.set(2,3);
    	lru.set(3,3);
    	lru.set(4,3);
    	lru.set(3,3);
    	lru.set(6,3);
    	lru.set(2,3);
    	lru.set(7,3);*/
    	/*lru.set(10,13);
    	lru.set(3,17);
    	lru.set(6,11);
    	lru.set(10,5);
    	lru.set(9,10);
    	lru.get(13);*/
    	
    	lru.set(2, 1);
    	//lru.get(2);
    	lru.set(1,1);
    	//lru.get(2);
    	lru.set(2, 3);
    	lru.set(4,1);
    	lru.get(1);
    	lru.get(2);
    	System.out.println("head is " + lru.head);
    	System.out.println("tail is " + lru.tail);
    	
    	System.out.println(lru.innerMap);
    	
    }
}