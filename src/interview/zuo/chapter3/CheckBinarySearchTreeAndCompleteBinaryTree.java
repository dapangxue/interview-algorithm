package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static void main(String[] args) {
        int[] array = {11, 4, 12, 2, 6, 10, 14};
        TreeNode head = createBinaryTreeByArray(array);
        System.out.println(checkIsBinarySearchTree(head));
    }
}
