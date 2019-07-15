package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by IDEA
 * 左程云算法-根据后续数组重建搜索二叉树P145
 * @author wuxue
 * @date 19-5-7
 */
public class PosArrayToBST {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /*
    搜索二叉树的性质：左子树任意的结点小于根节点，右子树的结点大于根节点，根节点的左子树和右子树也符合二叉搜索树
    思路：
    1、如果一个数组是通过二叉搜索树后续遍历得到的数组，那么数组的前一部分的值都小于数组的最后一位元素，
    数组的后一部分的值都大于最后一位元素
    2、且这两部分数组本身也是二叉搜索树后序遍历得到的数组
     */
    /**
     * 判断一个数组是否是后续遍历的数组
     * @param array
     * @return
     */
    public static boolean isPostArray(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return isPostArray(array, 0, array.length - 1);
    }

    /**
     * 判断一个数组是否是后续遍历的数组
     * @param array
     * @param start 数组的起点index,不一定为0
     * @param end 数组的结尾下标
     * @return
     */
    public static boolean isPostArray(int[] array, int start, int end) {
        if (start >= end) {
            return true;
        }

        int v = array[end];
        int i = start;
        for (; i < end; i++) {
            if (array[i] > v) {
                break;
            }
        }
        // 此时i为大于后续遍历最后一位数的下标
        for (int j = i; j < end; j++) {
            if (array[j] < v) {
                return false;
            }
        }

        return isPostArray(array, start, i - 1) && isPostArray(array, i, end - 1);
    }

    public static TreeNode postArrayToBST(int[] array) {
        if (!isPostArray(array)) {
            return null;
        }

        return postArrayToBST(array, 0, array.length - 1);
    }

    public static TreeNode postArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(array[end]);
        int i = start;
        for (; i < end; i++) {
            if (array[i] > array[end]) {
                break;
            }
        }

        root.left = postArrayToBST(array, start, i - 1);
        root.right = postArrayToBST(array, i, end - 1);
        return root;
    }

    /**
     * 非递归的后序遍历
     * @param head
     * @return
     */
    public static List<Integer> postTraversal(TreeNode head) {
        List<Integer> list = new ArrayList<>();

        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                stack2.push(temp.value);
                if (temp.left != null) {
                    stack1.push(temp.left);
                }
                if (temp.right != null) {
                    stack1.push(temp.right);
                }
            }
            while (!stack2.isEmpty()) {
                list.add(stack2.pop());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] postArray = {2, 6, 4, 10, 14, 12, 8};
        // System.out.println(isPostArray(postArray));
        TreeNode head = postArrayToBST(postArray);
        System.out.println(postTraversal(head));
    }
}
