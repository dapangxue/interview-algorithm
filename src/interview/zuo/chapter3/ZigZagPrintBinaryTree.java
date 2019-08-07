package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-13
 */
public class ZigZagPrintBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode>[] stack = new Stack[2];
            stack[0] = new Stack();
            stack[1] = new Stack();
            int fix = 0;
            stack[fix].push(root);
            while (!stack[0].isEmpty() || !stack[1].isEmpty()) {
                List<Integer> list = new ArrayList<>();
                if ((fix & 1) == 0) {
                    while (!stack[0].isEmpty()) {
                        root = stack[0].pop();
                        if (root.left != null) {
                            stack[1].push(root.left);
                        }
                        if (root.right != null) {
                            stack[1].push(root.right);
                        }
                        list.add(root.value);
                    }
                } else {
                    while (!stack[1].isEmpty()) {
                        root = stack[1].pop();
                        if (root.right != null) {
                            stack[0].push(root.right);
                        }
                        if (root.left != null) {
                            stack[0].push(root.left);
                        }
                        list.add(root.value);
                    }
                }
                result.add(list);
                System.out.println(result);
                fix = fix == 0 ? 1 : 0;
            }
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode>[] stack = new Stack[2];
        stack[0] = new Stack();
        stack[1] = new Stack();
        // 确认stack的索引
        int fix = 0;
        stack[fix].push(root);

        while (!stack[0].isEmpty() || !stack[1].isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if ((fix & 1) == 0) {
                while (!stack[fix].isEmpty()) {
                    TreeNode t = stack[fix].pop();
                    list.add(t.value);
                    if (t.left != null) {
                        stack[1].push(t.left);
                    }
                    if (t.right != null) {
                        stack[1].push(t.right);
                    }
                }
            } else {
                while (!stack[fix].isEmpty()) {
                    TreeNode t = stack[fix].pop();
                    list.add(t.value);
                    if (t.right != null) {
                        stack[0].push(t.right);
                    }
                    if (t.left != null) {
                        stack[0].push(t.left);
                    }
                }
            }

            result.add(list);
            fix = fix == 0 ? 1 : 0;
        }
        return result;
    }
}
