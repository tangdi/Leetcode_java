import java.util.List;

import IntersectionofTwoLinkedLists.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return null;
		int count = 1;
		List<Integer> record = new ArrayList<Integer>();
		ListNode node = head;
		ListNode nodeHead = null;
		while(count <=n){
			if(count < m){
				count ++;
				
				node = node.next;
				continue;
			}
			if(count ==m){
				nodeHead = node;
			}
			
			count++;
			record.add(node.val);
			node = node.next;
		}
		
		node = nodeHead;
		for(int i=0, j=record.size()-1; i<j; i++, j--){
			int temp = record.get(j);
			record.set(j, record.get(i));
			record.set(i, temp);
		}
		
		for(int i=0; i<record.size(); i++){
			node.val = record.get(i);
			node = node.next;
			
		}
		return head;
	}
}
