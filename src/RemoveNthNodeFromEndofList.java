import IntersectionofTwoLinkedLists.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}

		int target = length - n;
		int index = 0;
		node = head;
		ListNode pre = null;
		while (index < target) {
			pre = node;
			node = node.next;
			index++;
		}
		if (pre != null) {
			pre.next = node.next;
			node.next = null;
		}else{
			
			head = head.next;
		}
		return head;

	}
}
