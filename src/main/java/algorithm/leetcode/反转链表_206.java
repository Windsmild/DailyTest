package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-01 22:54
 */
public class 反转链表_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)  {
            return head;
        }
        ListNode subListHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return subListHead;
    }
    public ListNode reverseList2(ListNode head) {
       if (head == null) {
           return null;
       }
       ListNode p1 = head;
       ListNode p2 = head.next;
       p1.next = null;
       while (p2 != null) {
           ListNode tmp = p2.next;
           p2.next = p1;
           p1 = p2;
           p2 = tmp;
       }
       return p1;
    }
}
