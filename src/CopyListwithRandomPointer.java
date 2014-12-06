import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	
    	if (head == null) return null;
    	
    	Map<Integer, List<RandomListNode>> origin_map= new HashMap<Integer, List<RandomListNode>>();
    	Map<Integer, List<RandomListNode>> copy_map= new HashMap<Integer, List<RandomListNode>>();
        RandomListNode origin = head;
        RandomListNode copy = new RandomListNode(origin.label);
        RandomListNode copyHead = copy;
        
        List<RandomListNode> origin_list = new ArrayList<RandomListNode>();
        origin_list.add(origin);
        List<RandomListNode> copy_list = new ArrayList<RandomListNode>();
        copy_list.add(copy);
        
        origin_map.put(origin.label, new ArrayList<RandomListNode>(origin_list) );
        copy_map.put(origin.label, new ArrayList<RandomListNode>(copy_list) );
        
        while(origin.next != null){
        	copy.next = new RandomListNode(origin.next.label);
        	origin = origin.next;
        	copy = copy.next;
        	
        	if(origin_map.containsKey(origin.label)){
        		origin_list = origin_map.get(origin.label);
        		origin_list.add(origin);
        		copy_list = copy_map.get(copy.label);
        		copy_list.add(copy);
        		//origin_map.put(origin.label, origin_list);
        		//copy_map.put(origin.label, copy_list);  		
        		
        	}else{
        		origin_list = new ArrayList<RandomListNode>();
        		origin_list.add(origin);
        		copy_list = new ArrayList<RandomListNode>();
        		copy_list.add(copy);
        		origin_map.put(origin.label,origin_list );
                copy_map.put(origin.label, copy_list);
                
        	}	
        }
        
        copy.next=null;
        
        origin = head;
        copy = copyHead;
        while(origin != null){
        	if(origin.random == null){
        		copy.random = null;
        	}else{
        	origin_list = origin_map.get(origin.random.label);
        	copy_list = copy_map.get(origin.random.label);
        	
        	int index = 0;
        	for(int i=0; i<origin_list.size(); i++ ){
        		if(origin.random == origin_list.get(i)){
        			index = i;
        			break;
        		}
        	}
        	
        	
        	copy.random = copy_list.get(index);}
        	origin = origin.next;
        	copy = copy.next;
        	
        }
        
        return copyHead;
    }
    
    public static class RandomListNode {
    	     int label;
    	   RandomListNode next, random;
    	     RandomListNode(int x) { this.label = x; }
    	 };
}
