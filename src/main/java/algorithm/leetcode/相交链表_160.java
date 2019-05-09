package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-01 10:44
 */
public class 相交链表_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALength = 0;
        int headBLength = 0;
        ListNode p = headA;
        while (p != null) {
            headALength++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            headBLength++;
            p = p.next;
        }
        while (headALength > headBLength) {
            headA = headA.next;
            headALength--;
        }
        while (headBLength > headALength) {
            headB = headB.next;
            headBLength--;
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
