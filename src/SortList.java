import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import IntersectionofTwoLinkedLists.ListNode;


public class SortList {
    public ListNode sortList(ListNode head) {
        List<Integer> val = new ArrayList<Integer>();
        ListNode node = head;
        while(node != null){
        	val.add(node.val);
        	node = node.next;
        }
        
        if (val.size() <=1) return head;
        
        Collections.sort(val);
        node = head;
        int i=0;
        while(node != null){
        	node.val = val.get(i);
        	node = node.next;
        	i++;
        }
        return head;
    }
}
