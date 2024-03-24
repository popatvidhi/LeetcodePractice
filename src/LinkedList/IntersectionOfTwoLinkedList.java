package LinkedList;

public class IntersectionOfTwoLinkedList {

    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(5);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(8, e3);
        ListNode e1 = new ListNode(1, e2);
        ListNode list1 = new ListNode(4, e1);

        ListNode s5 = new ListNode(5);
        ListNode s4 = new ListNode(4, s5);
        ListNode s3 = new ListNode(8, s4);
        ListNode s2 = new ListNode(1, s3);
        ListNode s1 = new ListNode(6, s2);
        ListNode list2 = new ListNode(5, s1);

        ListNodeUtils nodeUtils = new ListNodeUtils();

        //ListNode nulllist1 = null;
        //ListNode nulllist2 = new ListNode();
        nodeUtils.printList(list1);
        nodeUtils.printList(list2);
        res = getIntersectionNode(list1, list2);
        nodeUtils.printList(res);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return b;
    }
}
