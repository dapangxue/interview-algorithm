package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-8
 */
public class DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 判断第一个结点是否是重复结点
        if (pHead.val != pHead.next.val) {
            pHead.next =  deleteDuplication(pHead.next);
            return pHead;
        } else {
            // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode.next != null && pNode.next.val == pNode.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode.next);
        }
    }
}
