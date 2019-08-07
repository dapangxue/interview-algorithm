package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/20 0020
 */
public class DeleteDuplication {
    static class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        // fix表示当前节点
        ListNode fix = pHead;
        while (fix != null) {
            // 如果当前节点下一节点和当前节点值相等
            while (fix.next != null && fix.next.val == fix.val) {
                ListNode t = fix.next;
                fix.next = fix.next.next;
                // help GC
                t.next = null;
            }
            fix = fix.next;
        }
        return pHead;
    }

    public static ListNode deleteDuplication1(ListNode pHead) {
        // 判断头结点是否为空
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        // 第一个节点不是重复节点
        if (pHead.next.val != pHead.val) {
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        } else {
            ListNode t = pHead.next.next;
            while (t != null && t.val == pHead.val) {
                t = t.next;
            }
            if (t == null) {
                return null;
            }
            return deleteDuplication1(t);
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        System.out.println(deleteDuplication(a));
    }
}
