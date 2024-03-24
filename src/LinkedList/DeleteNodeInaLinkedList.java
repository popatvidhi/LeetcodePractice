package LinkedList;

public class DeleteNodeInaLinkedList {

    public static void main(String args[]){
        ListNode res = new ListNode();

        ListNode e3 = new ListNode(9);
        ListNode e2 = new ListNode(1, e3);
        ListNode e1 = new ListNode(5, e2);
        ListNode head = new ListNode(4, e1);


        ListNodeUtils nodeUtils = new ListNodeUtils();
        nodeUtils.printList(head);
        deleteNode(e1);
        nodeUtils.printList(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
