package LinkedList;

import LinkedList.ListNode;
import LinkedList.ListNodeUtils;

public class RemoveNthNodeFromEndOfList {
    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = removeNthFromList(head,2);
        nodeUtils.printList(res);
    }

    public static ListNode removeNthFromList(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;

        while(n>0 && right!=null){
            right = right.next;
            n -=1;
        }

        while(right !=null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
