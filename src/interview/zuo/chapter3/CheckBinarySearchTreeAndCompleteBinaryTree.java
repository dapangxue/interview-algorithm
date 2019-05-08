package interview.zuo.chapter3;

import java.util.*;

/**
 * Create by IDEA
 * 左程云算法-判断二叉树是否是搜索二叉树和完全二叉树 P147
 * @author wuxue
 * @date 19-5-7
 */
public class CheckBinarySearchTreeAndCompleteBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 通过中序遍历升序判断是否为二茬搜索树
     * @param head
     * @return
     */
    public static boolean checkIsBinarySearchTree(TreeNode head) {
        if (head != null) {
            int temp = Integer.MIN_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            while (head != null || !stack.isEmpty()) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (temp < head.value) {
                        temp = head.value;
                    } else {
                        return false;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static TreeNode createBinaryTreeByArray(int[] array) {
        List<TreeNode> list = new ArrayList<>(array.length);
        for (int i = 0, length = array.length; i < length; i++) {
            list.add(new TreeNode(array[i]));
        }

        int lastParentTreeNodeIndex = array.length / 2 - 1;
        for (int i = 0; i < lastParentTreeNodeIndex; i++) {
            list.get(i).left = list.get(i * 2 + 1);
            list.get(i).right = list.get(i * 2 + 2);
        }

        list.get(lastParentTreeNodeIndex).left = list.get(lastParentTreeNodeIndex * 2 + 1);
        if ((list.size() & 1) == 1) {
            list.get(lastParentTreeNodeIndex).right = list.get(lastParentTreeNodeIndex * 2 + 2);
        }
        return list.get(0);
    }

    /*
    判断一个树是否是完全二叉树的要点：
    1、使用层次遍历
    2、如果一个结点没有左子结点，有右子结点返回false
    3、如果一个结点没有左右子结点，那么后续的结点也不能有左右子结点，否则返回false
    4、遍历过程中满足上述条件的都返回false,否则返回true
     */
    /**
     * 判断一个树是否是完全二叉树
     * @param head
     * @return
     */
    public static boolean isCompleteBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        // 表示是否已经出现过叶子节点
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            // 已经有节点是叶子结点，那么后续的结点必须都为叶子结点
            if (temp.left == null && temp.right == null) {
                leaf = true;
            }

            if (temp.right != null && temp.left == null) {
                return false;
            }

            if (leaf && (temp.left != null || temp.right != null)) {
                return false;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {11, 4, 12, 2, 6, 10, 14};
        TreeNode head = createBinaryTreeByArray(array);
        System.out.println(checkIsBinarySearchTree(head));
        System.out.println(isCompleteBinaryTree(head));
    }
}
