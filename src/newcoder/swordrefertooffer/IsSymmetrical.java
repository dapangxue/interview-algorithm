package newcoder.swordrefertooffer;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-9
 */
public class IsSymmetrical {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    // 方法1
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && helper(left.left, right.right)
                && helper(left.right, right.left);
    }

    // 方法二
    public boolean isSymmetricalDFS(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(right.left);
            stack.push(left.right);
        }
        return true;
    }
}
