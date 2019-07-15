package leetcode.chapter3;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * LeetCode 206题
 * https://leetcode-cn.com/articles/reverse-linked-list/
 * @author WuXue
 * @date 2019/6/12 0012
 */
public class ReverseList {

    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 采用迭代的方法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }
        return newHead;
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = reverseList1(head.next);
        head.next.next = head;
        // head.next = null;
        return t;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseList1(node1).next.value);
    }
}
