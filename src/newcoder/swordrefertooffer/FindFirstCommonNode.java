package newcoder.swordrefertooffer;

import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-15
 */
public class FindFirstCommonNode {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListNodeLength(pHead1);
        int length2 = getListNodeLength(pHead2);

        // 获取两个链表长度的差
        int diff = Math.abs(length1 - length2);
        if (length1 > length2) {
            for (int i = 0; i < diff; i++) {
                pHead1 = pHead1.next;
            }
        } else if (length1 < length2) {
            for (int i = 0; i < diff; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    private static int getListNodeLength(ListNode head) {
        int count = 0;
        ListNode dummyHead = head;
        while (dummyHead != null) {
            count++;
            dummyHead = dummyHead.next;
        }
        return count;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode commonFirstNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            stack1.pop();
            commonFirstNode = stack2.pop();
        }
        return commonFirstNode;
    }
}
