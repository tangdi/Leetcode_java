import IntersectionofTwoLinkedLists.ListNode;


public class ReorderList {
	 public void reorderList(ListNode head) {
		 if(head == null ) return;
	     ListNode node = head;  
	     List<ListNode> list = new ArrayList<ListNode>();
	     while(node !=null){
	    	 list.add(node);
	    	 node = node.next;
	     }
         if (list.size() <=2) return;
         int i=0, j=0;
	     for(i=0, j = list.size()-1; i<j; i++, j--){
	    	 head = list.get(i);
	    	 ListNode tail = list.get(j);
	    	 tail.next = head.next;
	    	 head.next = tail;
	    	 
	     }
	     
	     list.get(i).next = null;
	    }
	    }

