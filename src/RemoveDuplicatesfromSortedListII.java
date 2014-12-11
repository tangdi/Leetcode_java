import java.util.List;

import IntersectionofTwoLinkedLists.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode newHead = null;
		ListNode lastUnique = null;
		ListNode pre = head;
		ListNode node = head.next;
		boolean repeat = false;
		
		while(node != null){
			
			if(pre.val == node.val){
				repeat = true;
				node = node.next;
				continue;
			}
			
			if(repeat && pre.val != node.val){
				if(lastUnique != null){
					lastUnique.next = node;
				}
				pre = node;
				node = node.next;
				
				repeat = false;
				continue;
				
			}
			if(!repeat && pre.val != node.val){
				
				lastUnique = pre;
				if(newHead == null){
					newHead = lastUnique;
				}
				pre = node;
				node = node.next;
				continue;
			}
			
			}
		
		if(lastUnique == null){
			if(repeat){
				return null;
			}else{
				return pre;
			}
		}
		
		if(repeat){
			lastUnique.next = null;
		}else{
			lastUnique.next = pre;
		}
		
		return newHead;
		
	}
}
