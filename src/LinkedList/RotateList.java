package LinkedList;

public class RotateList {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = rotateRight(head, 2);
        nodeUtils.printList(res);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        k = k%len;
        if(k == 0){
            return head;
        }

        ListNode curr = head;
        for(int i = 0; i < len - k - 1; i++){
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;

        tail.next = head;
        return newHead;

    }
}
