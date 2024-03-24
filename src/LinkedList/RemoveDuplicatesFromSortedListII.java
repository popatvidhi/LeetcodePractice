package LinkedList;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e7 = new ListNode(5);
        ListNode e6 = new ListNode(4,e7);
        ListNode e5 = new ListNode(4,e6);
        ListNode e4 = new ListNode(3,e5);
        ListNode e3 = new ListNode(3, e4);
        ListNode e2 = new ListNode(2, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = deleteDuplicates(head);
        nodeUtils.printList(res);
    }


    public static ListNode deleteDuplicates(ListNode head) {
        return new ListNode();
    }
}
