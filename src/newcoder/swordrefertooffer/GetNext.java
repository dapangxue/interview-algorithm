package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-9
 */
public class GetNext {

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        // 1. 判断pNode结点是否有右结点
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            // 只要左子结点不为空，一直向下遍历
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 2.到这可以得出该结点没有右侧二叉子树
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
