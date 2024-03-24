package LinkedList;

public class ReverseLinkedListII {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = reverseBetween(head, 2, 4);
        nodeUtils.printList(res);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;
        ListNode curr = head;
        for(int i = 0; i < left - 1; i++){
            leftPrev = curr;
            curr = curr.next;
        }

        ListNode prev = null;
        for(int i = 0; i < right - left + 1; i++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;

    }
}
