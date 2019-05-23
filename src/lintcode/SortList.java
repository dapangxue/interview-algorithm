package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/23 0023
 */
public class SortList {
    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftDummy = new ListNode(-1), leftTail = leftDummy;
        ListNode midDummy = new ListNode(-1), midTail = midDummy;
        ListNode rightDummy = new ListNode(-1), rightTail = rightDummy;

        // 获取中间结点
        ListNode mid = getMid(head);
        while (head != null) {
            if (head.value < mid.value) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else if (head.value > mid.value) {
                rightTail.next = head;
                rightTail = rightTail.next;
            } else {
                midTail.next = head;
                midTail = midTail.next;
            }
            head = head.next;
        }

        leftTail.next = null;
        midTail.next = null;
        rightTail.next = null;

        leftDummy.next = quickSortList(leftDummy.next);
        rightDummy.next = quickSortList(rightDummy.next);
        return combine(leftDummy.next, midDummy.next, rightDummy.next);
    }

    public static ListNode combine(ListNode left, ListNode mid, ListNode right) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        tail.next = left;
        tail = getTail(tail);
        tail.next = mid;
        tail = getTail(tail);
        tail.next = right;
        tail = getTail(tail);
        return dummy.next;
    }

    /**
     * 获取一个链表的尾结点
     * @param head
     * @return
     */
    public static ListNode getTail(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    /**
     * 获取链表中间的结点，作为partition
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 6, 7};
        int[] b = {3, 7, 1, 2, 1, 3, 9, 10, 0};
        ListNode head = createList(b);
        // head = quickSortList(head);
        // System.out.println(printList(head));
        head = mergeSortList(head);
        System.out.println(printList(head));
    }

    /**
     * 通过数组创建链表
     * @param a
     * @return
     */
    public static ListNode createList(int[] a) {
        List<ListNode> list = new ArrayList<>(a.length);
        for (int i = 0, length = a.length; i < length; i++) {
            list.add(new ListNode(a[i]));
            if (i >= 1) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return list.get(0);
    }

    public static List<Integer> printList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    /*
    以下为归并排序的做法：

     */

    /**
     * 获取中间结点
     * @param head
     * @return
     */
    public static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidNode(head);
        ListNode right = mergeSortList(mid.next);
        mid.next = null;
        ListNode left = mergeSortList(head);

        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), tail = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                tail.next = left;
                left = left.next;
            } else if (left.value >= right.value) {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left == null) {
            tail.next = right;
        } else if (right == null) {
            tail.next = left;
        }

        return dummy.next;
    }
}
