package leetcode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步: 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2 步: 1->2->0->NULL 向右旋转 3 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 *
 * @author Stephen Cai
 * @date 2019-03-17 18:35
 */
public class 旋转链表_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cursor = head;
        ListNode tail = null;
        int length = 1;
        while (cursor.next != null) {
            cursor = cursor.next;
            length++;
        }
        //先遍历一遍，得出链表长度 len，注意 k 可能大于 len，因此令k = (len + (k % len)) % len;。
        int loop = length - (k % length);
        tail = cursor;
        cursor.next = head;
        cursor = head;
        for (int i = 0; i < loop; i++) {
            cursor = cursor.next;
            tail = tail.next;
        }
        tail.next = null;
        return cursor;
    }
}
