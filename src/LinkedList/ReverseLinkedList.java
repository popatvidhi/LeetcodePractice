package LinkedList;

import LinkedList.ListNode;
import LinkedList.ListNodeUtils;

public class ReverseLinkedList {
    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = reverseList(head);
        nodeUtils.printList(res);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode();
        ListNode prev = null;
        while(head!=null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
