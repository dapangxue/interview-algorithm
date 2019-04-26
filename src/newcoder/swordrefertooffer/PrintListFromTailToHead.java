package newcoder.swordrefertooffer;

import java.util.ArrayList;

/**
 * Create by IDEA
 * 本题是剑指offer第三题的一个变种，改变了链表的数据结构
 * @author wuxue
 * @date 18-12-30
 */
public class PrintListFromTailToHead {
    /**
     * 定义一个结点的数据结构
     */
    static class ListNode {
        public ListNode next = null;
        public int value;

        ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 输入一个链表
     * @param head
     * @return
     */
    public static ListNode printListFromTailToHead(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode e = printListFromTailToHead(a);
        ListNode f = e.next;
        ListNode g = f.next;
        ListNode h = g.next;
        System.out.println(e.value + " " + f.value + g.value + h.value);
        ListNode n = null;
        System.out.println(printListFromTailToHead(n));
    }
}
