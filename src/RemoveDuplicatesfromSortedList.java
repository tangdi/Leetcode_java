import java.util.Set;

import IntersectionofTwoLinkedLists.ListNode;


public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode node =head;
    	ListNode pre = null;
    	Set<Integer> memory = new HashSet<Integer>();
    	while(node != null){
    		if(memory.contains(node.val)){
    			pre.next = node.next;
    			
    		}else{
    			memory.add(node.val);
    			pre = node;
    		}
    		
    		node = node.next;
    	}
    	
    	return head;
        
    }
}
