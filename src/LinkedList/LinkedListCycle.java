package LinkedList;

public class LinkedListCycle {
    public static void main(String args[]){
        boolean res;
        ListNode e3 = new ListNode(4);
        ListNode e2 = new ListNode(0, e3);
        ListNode e1 = new ListNode(2, e2);
        e3.next = e1;
        ListNode head = new ListNode(3, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        //nodeUtils.printList(head);
        res = hasCycle(head);
        System.out.println(res);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        if(head == null)
            return false;
        while(runner != null && runner.next!=null ){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner)
                return true;
        }
        return false;
    }
}
