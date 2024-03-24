package LinkedList;

public class SortList {

    public static void main(String[] args){
        ListNode res = new ListNode();
        ListNode e4 = new ListNode(0);
        ListNode e3 = new ListNode(4, e4);
        ListNode e2 = new ListNode(3, e3);
        ListNode e1 = new ListNode(5, e2);
        ListNode head = new ListNode(-1, e1);
        ListNodeUtils nodeUtils = new ListNodeUtils();

        nodeUtils.printList(head);
        res = sortList(head);
        nodeUtils.printList(res);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //split list in 2 halves
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
    public static ListNode getMid(ListNode head){
        ListNode walker = head;
        ListNode runner = head.next;
        while(runner != null && runner.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }
    public static ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                res.next = left;
                left = left.next;
            }else{
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left == null ? right : left;
        return dummy.next;
    }

}
