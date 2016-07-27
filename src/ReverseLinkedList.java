/**
 * ClassName: ReverseLinkedList Function: TODO
 *
 * @Author: dtang
 * @Date: 7/27/16, 10:21 AM
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode node = p.next;
        while(node.next != null){
            ListNode n = node.next;
            node.next= n.next;
            n.next = p.next;
            p.next = n;
        }
        return dummy.next;
    }
}
