import IntersectionofTwoLinkedLists.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode newHead = null;
		ListNode node = newHead;
		int carry = 0;
		int sum = 0;
		while (l1 != null || l2 != null || carry != 0) {
			sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			sum = sum % 10;
			if (newHead == null) {
				newHead = new ListNode(sum);
				node = newHead;
			} else {
				node.next = new ListNode(sum);
				node = node.next;
			}

		}
		return newHead;
	}
}
