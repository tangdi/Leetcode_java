import IntersectionofTwoLinkedLists.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {

		ListNode node = head;
		ListNode smallHead = null;
		ListNode smallTail = null;
		
		ListNode largeHead = null;
		ListNode largeTail = null;
		
		while(node !=null){
			if(node.val < x){
				if(smallHead == null){
					smallHead = node;
					smallTail = node;
					node = node.next;
					continue;
				}
				smallTail.next = node;
				smallTail = smallTail.next;
				node = node.next;
				continue;
			}
			
			if(largeHead == null){
				largeHead = node;
				largeTail = node;
				node = node.next;
				continue;
			}
			largeTail.next = node;
			largeTail = largeTail.next;
			node = node.next;
			continue;
		}
		
		if(smallTail !=null){
			smallTail.next= largeHead;
		}
		if(largeTail != null){
			largeTail.next = null;
		}
		
		return smallHead == null? largeHead: smallHead;
	}
}
