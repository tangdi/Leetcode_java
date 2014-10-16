import java.util.HashMap;
import java.util.ArrayList;


public class LRUCache {
    private final int capacity;
    public ArrayList<Integer> FIFO; 
    public HashMap<Integer, Integer> innerMap;
  
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        FIFO = new ArrayList<Integer>();
        innerMap = new HashMap<Integer, Integer>();
       
        
    }
    
    public int get(int key) {
        if(key <= 0){
            return -1;
        }
        
        if(! innerMap.containsKey(key)){
            return -1;
        }
        
        int keyIndex = FIFO.indexOf(new Integer(key));
        FIFO.remove(keyIndex);
        FIFO.add(key);
        
        
      
	     
        return ((Integer)innerMap.get(key)).intValue();
    }
    
    public void set(int key, int value) {
    	//System.out.println(keyIndexMap);
    	if(innerMap.containsKey(key)){
    		 FIFO.remove((Integer)key);
    	    
    	}
    	FIFO.add(key);
    
        
        innerMap.put(key, value);
        if (innerMap.size() > capacity){
        	Integer popKey = FIFO.remove(0);
        	innerMap.remove(popKey);
        }
       // System.out.println(FIFO);
       
    }
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(10);
    /*	lru.set(2,3);
    	lru.set(3,3);
    	lru.set(4,3);
    	lru.set(3,3);
    	lru.set(6,3);
    	lru.set(2,3);
    	lru.set(7,3);*/
    	lru.set(10,13);
    	lru.set(3,17);
    	lru.set(6,11);
    	lru.set(10,5);
    	lru.set(9,10);
    	lru.get(13);
    	System.out.println(lru.FIFO);
    	
    	lru.set(2,19);
    	lru.get(2);
    	System.out.println(lru.FIFO);
    
    	lru.get(3);
    	System.out.println(lru.FIFO);
    	System.out.println(lru.innerMap);
    	
    }
}