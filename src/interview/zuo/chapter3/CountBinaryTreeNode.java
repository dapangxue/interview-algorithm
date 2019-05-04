package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-4
 */
public class CountBinaryTreeNode {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static int countBinaryTreeNode(TreeNode head) {
        /*
        1、根据完全二叉树的性质，如果右子树的高度等于h-1,那么左子树一定是满二叉树
        2、如果右子树的高度为h-2,那么右子树一定是满二叉树
         */
        // 获取二叉树的高度
        int h = getBinaryTreeHeight(head);

        int count = countBinaryTreeNode(head, 1, h);
        return count;
    }

    /**
     * 统计当前结点为头结点的二叉树的结点
     * @param head
     * @param level
     * @param h 二叉树的高度
     * @return
     */
    public static int countBinaryTreeNode(TreeNode head, int level, int h) {
        if (head == null) {
            return 0;
        }
        // 当前head结点算在内
        int count = 1;
        // 如果当前结点的右子树的高度为h - 1,则左子树必须为满二叉树
        if (getBinaryTreeHeight(head.right) == h - level) {
            count += Math.pow(2, h - level) - 1 + countBinaryTreeNode(head.right, level + 1, h);
        } else {
            count += Math.pow(2, h - level - 1) - 1 + countBinaryTreeNode(head.left, level + 1, h);
        }
        return count;
    }

    /**
     * 根据完全二叉树的性质，从根节点到最左边叶子结点的路径即为完全二叉树的高度
     * @param head
     * @return 完全二叉树的高度
     */
    public static int getBinaryTreeHeight(TreeNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.left;
        }
        return count;
    }

    /**
     * 常规方法获取二叉树的高度
     * @param head
     * @return
     */
    public static int getBinaryTreeHeightUsual(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int left = getBinaryTreeHeightUsual(head.left);
        int right = getBinaryTreeHeightUsual(head.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 根据数组创建完全二叉树
     * @param a
     * @return
     */
    public static TreeNode createBinaryTreeByArray(int[] a) {
        int length = a.length;
        List<TreeNode> list = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            list.add(new TreeNode(a[i]));
        }
        // 获取完全二叉树的最后一个父节点
        int lastParentTreeNodeIndex = length / 2 - 1;
        for (int i = 0; i < lastParentTreeNodeIndex; i++) {
            list.get(i).left = list.get(i * 2 + 1);
            list.get(i).right = list.get(i * 2 + 2);
        }

        list.get(lastParentTreeNodeIndex).left = list.get(lastParentTreeNodeIndex * 2 + 1);
        if ((length & 1) == 1) {
            list.get(lastParentTreeNodeIndex).right = list.get(lastParentTreeNodeIndex * 2 + 2);
        }
        return list.get(0);
    }

    /**
     * 非递归的方式实现前序遍历
     * @param head
     * @return
     */
    public static List<Integer> preOrder(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.value);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        TreeNode head = createBinaryTreeByArray(a);
        System.out.println(preOrder(head));
        System.out.println(countBinaryTreeNode(head));
    }
}
