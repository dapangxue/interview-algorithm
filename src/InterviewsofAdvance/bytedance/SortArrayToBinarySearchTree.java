package InterviewsofAdvance.bytedance;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * 给一个排序数组，转成高度最小的二叉树
 * @author WuXue
 * @date 2019/7/22 0022
 */
public class SortArrayToBinarySearchTree {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortArrayToBinarySearchTree(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    public static TreeNode helper(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array, start, mid - 1);
        root.right = helper(array, mid + 1, end);
        return root;
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode t = stack1.pop();
                if (t.left != null) {
                    stack1.push(t.left);
                }
                if (t.right != null) {
                    stack1.push(t.right);
                }
                stack2.push(t);
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().val + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = sortArrayToBinarySearchTree(array);
        postOrder(root);
    }

}
