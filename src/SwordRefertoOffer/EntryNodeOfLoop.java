package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/21 0021
 */
public class EntryNodeOfLoop {

    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 链表中环的入口节点
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 如果链表长度不足两个节点，那么不会构成环
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        // 有环的情况
        if (fast == slow && fast != null) {
            fast = pHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }
    }

}
