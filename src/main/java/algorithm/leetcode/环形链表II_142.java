package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-25 10:09
 */
public class 环形链表II_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowIndex = head;
        ListNode fastIndex = head;
        /**
         * 假设从链表开始的位置到环入口的距离为p，慢指针在环内走了的距离为c，假设慢指针一共走了n步，快指针一共做了2n步。
         * 那么，有p+c=n
         * 显然，从p+c这一点开始，慢指针再走n步，必然还会回到这个点。为啥？【因为经过了2n步，快指针到达了这一点，所以慢指针如果再走n步，也会到达这一点】
         * 如果让快指针从链表头开始走n步，也会到达p+c这个位置，二者相遇的第一个地方，肯定是环入口。
         */
        while (fastIndex != null && fastIndex.next != null) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next.next;
            if (slowIndex == fastIndex) {
                slowIndex = head;
                while (slowIndex != fastIndex) {
                    slowIndex = slowIndex.next;
                    fastIndex = fastIndex.next;
                }
                return slowIndex;
            }
        }
        return null;

    }
}
