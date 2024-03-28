package LinkedList;

public class MergeKSortedList {

    public static void main(String arg[]){

        ListNodeUtils nodeUtils = new ListNodeUtils();

        ListNode l2 = new ListNode(5);
        ListNode l1 = new ListNode(4, l2);
        ListNode list1 = new ListNode(1, l1);

        ListNode e2 = new ListNode(4);
        ListNode e1 = new ListNode(3, e2);
        ListNode list2 = new ListNode(1, e1);

        ListNode s1 = new ListNode(6 );
        ListNode list3 = new ListNode(2, s1);

        ListNode[] lists = {list1, list2, list3};
        for(ListNode l : lists){
            nodeUtils.printList(l);
        }
        ListNode res = mergeKLists(lists);
        nodeUtils.printList(res);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }
        while(lists.length > 1){
            ListNode[] mergedLists = new ListNode[(lists.length + 1) / 2];
            int j = 0;
            for(int i = 0; i < lists.length; i += 2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[ i + 1] : null;
                mergedLists[j++] = merge(l1, l2);
            }
            lists = mergedLists;
        }
        return lists[0];
    }
    public static  ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            } else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
