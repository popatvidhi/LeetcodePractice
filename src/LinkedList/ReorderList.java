package LinkedList;

public class ReorderList {
    public static void main(String args[]){
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(2, e2);
        ListNode head = new ListNode(1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        reorderList(head);
        nodeUtils.printList(head);
    }

    public static void reorderList(ListNode head) {

        /* Find the second half of the list using slow fast runners*/
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        /*Reverse the second half*/
        ListNode temp = new ListNode();
        ListNode prev = slow.next;
        while(second != null){
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        /* begining of second list is from prev because we reversed the list*/
        second = prev;

        /*Merge both first and second List*/
        ListNode storeFirstHalf = new ListNode();
        ListNode storeSecondtHalf = new ListNode();
        while(second != null){
            storeFirstHalf = head.next;
            storeSecondtHalf = second.next;
            head.next = second;
            second.next = storeFirstHalf;
            head = storeFirstHalf;
            second = storeSecondtHalf;
        }
    }
}
