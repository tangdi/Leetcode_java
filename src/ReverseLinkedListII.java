import java.util.ArrayList;
import java.util.List;


public class ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
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
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if(head ==null || m == n) return head;
		ListNode mNode = head, nNode = head, mNodePrev= null, nNodeNext = null;
		while(--m >0){
			mNodePrev = mNode;
			mNode = mNode.next;
		}
		nNode = mNode;
		int delta = n - m;
		ListNode nNodePrev = null;
		while(delta-- >= 0){
			ListNode next = nNode.next;
			nNode.next = nNodePrev;
			nNodePrev = nNode;
			nNode = next;
		}
		mNode.next = nNode;
		if(mNodePrev != null){
			mNodePrev.next = nNodePrev;
			return head;
		}else{
			return nNodePrev;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
		ListNode root = new ListNode(3);
		ListNode leaf = new ListNode(5);
		root.next = leaf;
		reverseLinkedListII.reverseBetween2(root, 1,2);
	}
}
