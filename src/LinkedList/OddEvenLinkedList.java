package LinkedList;

public class OddEvenLinkedList {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = oddEvenList(head);
        nodeUtils.printList(res);
    }


    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddst = head;
        ListNode evenst = head.next;
        ListNode even = evenst;
        ListNode odd = oddst;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenst;
        return oddst;
    }
}
