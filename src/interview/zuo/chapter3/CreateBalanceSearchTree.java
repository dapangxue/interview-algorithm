package interview.zuo.chapter3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-8
 */
public class CreateBalanceSearchTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /*
    分析：如果题目要求只生成一个二叉搜索树，那么可以生成好多种
    如果还要求生成平衡二叉搜索树，则要求根节点的左子树和右子树高度相差不超过1，且左子树和右子树都必须为平衡二叉树
    比如：
                    8                              5
                   /                            /    \
                  7                            2     7
                 /                            / \   /  \
                6                            1   3  6  8
               /                                  \
              5                                    4
             /
            4
           /
          3
         /
        2
       /
      1
     */
    /**
     * 通过有序数组生成平衡搜索二叉树
     * @param array
     * @return
     */
    public static TreeNode createBalanceSearchTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createBalanceSearchTree(array, 0, array.length - 1);
    }

    /**
     * 创建一个数组某个分段内的平衡二叉搜索树
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static TreeNode createBalanceSearchTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(array[mid]);
        head.left = createBalanceSearchTree(array, start, mid - 1);
        head.right = createBalanceSearchTree(array, mid + 1, end);
        return head;
    }

    /**
     * 非递归的中序遍历
     * @param head
     * @return
     */
    public static List<Integer> inOrder(TreeNode head) {
        List<Integer> list = new LinkedList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    list.add(head.value);
                    head = head.right;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3,4, 5, 6, 7, 8};
        TreeNode head = createBalanceSearchTree(array);
        System.out.println(inOrder(head));
    }
}
