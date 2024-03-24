package LinkedList;

public class AddTwoNumbers {
    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e2 = new ListNode(4);
        ListNode e1 = new ListNode(6, e2);
        ListNode l1 = new ListNode(5, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(l1);


        ListNode s2 = new ListNode(3);
        ListNode s1 = new ListNode(4, s2);
        ListNode l2 = new ListNode(2, s1);

        nodeUtils.printList(l2);
        res = addTwoNumbers(l1,l2);
        nodeUtils.printList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = fakeHead;
        int carry = 0;
        while(p!= null || q!= null){
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return fakeHead.next;
    }
}
