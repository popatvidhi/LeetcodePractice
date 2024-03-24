package LinkedList;

public class PartitionList {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e5 = new ListNode(2);
        ListNode e4 = new ListNode(5, e5);
        ListNode e3 = new ListNode(2, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(4, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = partition(head,3);
        nodeUtils.printList(res);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode ltail = left;
        ListNode rtail = right;
        while(head != null){
            if(head.val < x){
                ltail.next = head;
                ltail = ltail.next;
            }else{
                rtail.next = head;
                rtail = rtail.next;
            }
            head = head.next;
        }
        ltail.next = right.next;
        rtail.next = null;
        return left.next;
    }
}
