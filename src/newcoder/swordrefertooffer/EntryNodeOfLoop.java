package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-8
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null
                || pHead.next == null
                || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        // 首先判断有没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 有环
            if (fast == slow) {
                break;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
