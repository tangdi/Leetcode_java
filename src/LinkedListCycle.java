//public class LinkedListCycle {
//	public boolean hasCycle(ListNode head) {
//		 public boolean hasCycle(ListNode head) {
//
//		        if(head == null) return false;
//
//		        ListNode slow = head;
//		        ListNode fast = slow.next;
//
//		        while(fast != null && slow != null){
//		            if( fast == null){
//		                return false;
//		            }
//
//		            fast = fast.next;
//		            if(fast == slow){
//		                return true;
//		            }
//
//		            if(fast == null){
//		                return false;
//		            }
//
//		            fast = fast.next;
//		            if(fast == slow){
//		                return true;
//		            }
//
//		            if(fast == null){
//		                return false;
//		            }
//
//
//
//		            slow = slow.next;
//
//
//
//		        }
//
//		        return false;
//
//		    }
//
//	}
//}
