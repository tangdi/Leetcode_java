import java.util.ArrayList;
import java.util.List;

import IntersectionofTwoLinkedLists.ListNode;


public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        
        int length = 0;
        ListNode node = head;
        while(node !=null){
        	length ++;
        	node = node.next;
        }
        if(k>length) {
        	return head;
        }
        
        node = head;
        while(node != null){
        	List<Integer> record = new ArrayList<Integer>(k);
        	int i=0;
        	ListNode periodHead = node;
        	while(node!= null && i++<k){
        		record.add(node.val);
        		node = node.next;
        	}
        	if (record.size() < k){
        		break;
        	}
        	
        	for(int x=0, y=record.size()-1; x<y; x++, y--){
        		int temp = record.get(x);
        		record.set(x, record.get(y));
        		record.set(y, temp);
        	}
        	i = 0;
        	node = periodHead;
        	while(i<k){
        		node.val = record.get(i);
        		node = node.next;
        		i++;
        	}
        }
        return head;
    }
}
