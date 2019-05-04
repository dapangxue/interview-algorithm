package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-3
 */
public class Clone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        handleRandom(pHead);
        return segregateRandomListNode(pHead);
    }

    private void cloneNodes(RandomListNode phead) {
        RandomListNode dummy = phead;
        while (dummy != null) {
            RandomListNode copy = new RandomListNode(dummy.label);
            RandomListNode temp = dummy.next;
            dummy.next = copy;
            copy.next = temp;
            dummy = temp;
        }
    }

    private void handleRandom(RandomListNode phead) {
        RandomListNode dummy = phead;
        while (dummy != null) {
            if (dummy.random != null) {
                RandomListNode temp = dummy.random;
                dummy.next.random = temp.next;
            }
            dummy = dummy.next.next;
        }
    }

    private RandomListNode segregateRandomListNode(RandomListNode phead) {
        RandomListNode head = phead.next;
        RandomListNode dummy = phead;
        RandomListNode dummy1 = head;
        while (dummy != null) {
            RandomListNode temp = dummy.next.next;
            if (dummy1.next != null) {
                dummy1.next = temp.next;
            }
            dummy.next = temp;
            dummy = dummy.next;
            dummy1 = dummy1.next;
        }
        // System.out.println(head.label + " " + head.next.label + head.next.next.label + head.random.label);
        return head;
    }

    public static void main(String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode1.random = randomListNode3;
        Clone clone = new Clone();
        System.out.println(clone.Clone(randomListNode1).label);
//        System.out.println(randomListNode1.random.label);
    }

}
