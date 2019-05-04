package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-6
 */
public class Convert {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode previousNode = null;
        helper(pRootOfTree);

        TreeNode result = pRootOfTree;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    public TreeNode previousNode;
    /**
     * 将二叉查找树构建为双向链表
     *
     * @param currentNode 当前结点
     * @param previousNode 双向链表的最后一个结点
     */
    private void helper(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        helper(currentNode.left);
        currentNode.left = previousNode;

        if (previousNode != null) {
            previousNode.right = currentNode;
        }
        previousNode = currentNode;

        helper(currentNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(14);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(12);
        TreeNode treeNode6 = new TreeNode(16);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        Convert convert = new Convert();
        System.out.println(convert.printList(convert.Convert(treeNode0)));
    }

    private List<Integer> printList(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        while (root.right != null) {
            list.add(root.val);
            root = root.right;
        }

        System.out.println(root.val);
        while (root.left != null) {
            list.add(root.val);
            root = root.left;
        }

        return list;
    }

}
