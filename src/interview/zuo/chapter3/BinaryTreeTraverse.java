package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-5-5
 */
public class BinaryTreeTraverse {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 非递归的中序遍历
     * @param head
     * @return
     */
    public static List<Integer> inOrderUnRecur(TreeNode head) {
        List<Integer> list = new ArrayList<>();

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

    /**
     * 非递归的后序遍历
     * @param head
     * @return
     */
    public static List<Integer> posOrderUnRecur(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
                s2.push(head.value);
            }
            while (!s2.isEmpty()) {
                list.add(s2.pop());
            }
        }
        return list;
    }
}
