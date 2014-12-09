import IntersectionofTwoLinkedLists.ListNode;


public class SwapNodesinPairs {
	 public ListNode swapPairs(ListNode head) {
		 if(head == null) return null;
		 
	     ListNode node = head;
	     ListNode parent = null;
	     ListNode newHead = head;
	     
	     while(node != null && node.next != null){
	    	 ListNode temp = node.next;
	    	 node.next = temp.next;
	    	 temp.next = node;
	    	 if(parent != null){
	    		 parent.next = temp;
	    		 parent = parent.next.next;
	    	 }else{
	    		 newHead = temp;
	    		 parent = newHead.next;
	    	 }
	    	 node = node.next;
	    	 
	     }
	     return newHead;
	    }
}
