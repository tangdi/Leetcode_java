import IntersectionofTwoLinkedLists.ListNode;


public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        
        int length = 0;
        ListNode node = head;
        while(node != null){
        	length ++;
        	node = node.next;
        }
        
        if (length == 1) return head;
        
        n = n%length;
        
        while(n-->0){
        	node = head;
        	ListNode precessor = null;
        	int i =0;
        	while(node.next !=null){
        		precessor = node;
        		node = node.next;
        	}
        	precessor.next = null;
        	node.next = head;
        	head = node;
        }
        
       return head;
    }
}
