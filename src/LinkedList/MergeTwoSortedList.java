package LinkedList;

import LinkedList.ListNode;
import LinkedList.ListNodeUtils;

public class MergeTwoSortedList {
    public static void main(String args[]){
        ListNode res = new ListNode();
        ListNode e2 = new ListNode(4);
        ListNode e1 = new ListNode(2, e2);
        ListNode list1 = new ListNode(1, e1);

        ListNode s2 = new ListNode(4);
        ListNode s1 = new ListNode(3, s2);
        ListNode list2 = new ListNode(1, s1);

        ListNodeUtils nodeUtils = new ListNodeUtils();

        ListNode nulllist1 = null;
        ListNode nulllist2 = new ListNode();
        //nodeUtils.printList(list1);
        //nodeUtils.printList(list2);
        res = mergeList(nulllist1, nulllist2);
        nodeUtils.printList(res);
    }

    public static ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                res.next = list1;
                list1 = list1.next;
            } else{
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        res.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
