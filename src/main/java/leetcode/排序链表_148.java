package leetcode;

/**
 * 归并排序应该算是链表排序最佳的选择了，保证了最好和最坏时间复杂度都是nlogn，而且它在数组排序中广受诟病的空间复杂度在链表排序中也从O(n)降到了O(1)。
 *
 * 归并排序的一般步骤为：
 *
 * 将待排序数组（链表）取中点并一分为二；
 * 递归地对左半部分进行归并排序；
 * 递归地对右半部分进行归并排序；
 * 将两个半部分进行合并（merge）,得到结果。
 * 首先用快慢指针(快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表中点)的方法找到链表中间节点，然后递归的对两个子链表排序，把两个排好序的子链表合并成一条有序的链表。
 * @author Stephen Cai
 * @date 2019-03-25 22:51
 */
public class 排序链表_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return mergeSOrt(sortList(head),sortList(right));
    }
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick =quick.next.next;
        }
        return slow;
    }
    private ListNode mergeSOrt(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2,head;
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
