import java.util.List;
import java.util.PriorityQueue;

import IntersectionofTwoLinkedLists.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKListsSlow(List<ListNode> lists) {
		if (lists == null || lists.size() == 0){
			return null;
		}
		if(lists.size() == 1){
		    return lists.get(0);
		}
		ListNode newHead = null;
		ListNode node = null;
		ListNode min = null;
		int minIndex = 0;
		while (true) {
			
			
			for (int i = 0; i<lists.size(); i++) {
				ListNode iter = lists.get(i);
				if(iter == null){
				    continue;
				}

				if (min == null) {
					min = iter;
					minIndex = i;
				} else {
					if (iter.val < min.val) {
						min = iter;
						minIndex = i;
					}
				}
			}
			if(min == null){
			    break;
			}
			
			if(newHead == null){
				newHead = min;			
			}else{
				node.next = min;
			}
			node= min;
			node.next = null;
			min = null;
		}
	return newHead;
	}
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode ln1, ListNode ln2) {
						return ln1.val - ln2.val;
					}
				});

		// init
		for (ListNode head : lists) {
			if (head != null) {
				pq.add(head);
			}
		}

		// merge
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!pq.isEmpty()) {
			p.next = pq.poll();
			p = p.next;
			if (p.next != null) {
				pq.offer(p.next);
			}
		}

		return dummy.next;
	}
}
