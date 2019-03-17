package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-14 09:52
 */
public class 合并K个排序链表_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }
        return MSort(lists, 0, lists.length -1);
    }

    //归并排序
    public ListNode MSort(ListNode[] lists, int low, int high) {
        if (low <high) {
            int mid = (low + high) /2 ;
            ListNode leftList = MSort(lists, low , mid );
            ListNode rightList = MSort(lists, mid+1 , high);
            return mergeTwoLists(leftList,rightList);
        }
        return lists[low];
    }

    //合并排序
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            res = l1;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists(l1,l2.next);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        l1.next = l2;
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l3.next = l4;
        ListNode[] lists = new ListNode[] {l1,l3};
        new 合并K个排序链表_23().mergeKLists(lists);
    }
}
