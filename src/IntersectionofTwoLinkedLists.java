public class IntersectionofTwoLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
	        int lengthA=0;
	        int lengthB=0;
	        ListNode Alooper = headA;
	        ListNode Blooper = headB;
	        while(Alooper != null){
	            lengthA++;
	            Alooper = Alooper.next;
	        }
	        
	        while(Blooper != null){
	            lengthB++;
	            Blooper = Blooper.next;
	        }
	        Alooper = headA;
	        Blooper = headB;
	        if(lengthA>lengthB){
	            for(int i=0; i<lengthA-lengthB; i++){
	                Alooper = Alooper.next;
	            }
	        }else{
	            for(int i=0; i<lengthB-lengthA; i++){
	                Blooper = Blooper.next;
	            }
	        }
	        
	        while(Alooper !=null && Blooper!=null){
	            if(Alooper == Blooper ) return Alooper;
	            Alooper = Alooper.next;
	            Blooper = Blooper.next;
	        }
	        return null;
	        
	    }
	}
}
