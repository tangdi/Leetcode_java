public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode toSort = head.next;
		while (toSort != null) {
			ListNode pos = head;
			while (pos != toSort) {
				if (pos.val > toSort.val) {
					break;
				} else {
					pos = pos.next;
				}
			}

			if (pos == toSort) {
				toSort = toSort.next;
				continue;
			}

			int passDown = pos.val;
			pos.val = toSort.val;
			pos = pos.next;
			while (pos != toSort) {
				int temp = pos.val;
				pos.val = passDown;
				passDown = temp;
				pos = pos.next;
			}
			pos.val = passDown;
			toSort = toSort.next;

		}
		return head;
	}
}
