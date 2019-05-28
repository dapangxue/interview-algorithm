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
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        System.out.println(mid.value);
        ListNode leftDummy = new ListNode(-1), leftTail = leftDummy;
        ListNode midDummy = new ListNode(-1), midTail = midDummy;
        ListNode rightDummy = new ListNode(-1), rightTail = rightDummy;

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
        // todo 将三个链表结合
        return combine(leftDummy.next, midDummy.next, rightDummy.next);
    }

    public static ListNode combine(ListNode leftHead, ListNode midHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        tail.next = leftHead;
        tail = getTail(tail);
        tail.next = midHead;
        tail = getTail(tail);
        tail.next = rightHead;
        tail = getTail(tail);
        return dummy.next;
    }

    public static ListNode getTail(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }

    /**
     * 查找链表的中间点
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

    /*
    单链表的选择排序
    选择排序的思路是：每次都在未排好序的结点中选择最小的，拿到前面排序
     */
    public static ListNode selectSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
        核心代码思路：
        head表示未排序的链表的头结点，所以每次都需要从head处开始查找最小的结点
         */
        // 排序部分的头部和尾部
        ListNode dummy = new ListNode(-1), tail = dummy;
        // 此处不能用head当做当前节点
        ListNode currentNode = head;
        while (head != null) {
            // 认为当前节点是最小的结点
            ListNode minNode = head;
            // head表示未排序的链表的头结点，所以每次都需要从head处开始查找最小的结点
            ListNode tempNode = head;
            // 查找最小的结点
            while (tempNode != null) {
                if (tempNode.value < minNode.value) {
                    minNode = tempNode;
                }
                tempNode = tempNode.next;
            }
            // 查找最小节点对应的前驱结点
            ListNode minNodePreNode = getMinNodePreNode(head, minNode);
            if (minNodePreNode != null) {
                minNodePreNode.next = minNode.next;
            } else {
                head = head.next;
            }
            // currentNode = currentNode.next;
            tail.next = minNode;
            tail = tail.next;
            tail.next = head;
        }
        return dummy.next;
    }

    public static ListNode selectSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;

        while (head != null) {
            while (q != null) {
                if (q.value < head.value) {
                    int t = head.value;
                    head.value = q.value;
                    q.value = t;
                }
                q = q.next;
            }
            head = head.next;
            q = head;
        }
        return p;
    }

    /**
     * 获取最小值结点的前驱结点
     * @return
     */
    public static ListNode getMinNodePreNode(ListNode head, ListNode minNode) {
        // 1、首先判断头结点和最小结点是否相等，如果相等则没有前驱结点
        if (head == minNode) {
            return null;
        }

        while (head.next != minNode) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2};
        int[] b = {3, 7, 1, 2, 1, 3, 9, 10, 0};
        ListNode head = createList(b);
        System.out.println(printList(head));
        head = selectSortList2(head);
        // System.out.println(printList(head));
        // head = mergeSortList(head);
        System.out.println(printList(head));
    }

}
