package interview.zuo.chapter3;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 * 左程云算法-P140、判断t1树是否包含t2树全部的拓扑结构
 * P141、判断t1树中是否有t2树拓扑结构完全相同的子树
 * @author wuxue
 * @date 19-5-5
 */
public class CheckTreeAContainsTreeB {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode (int value) {
            this.value = value;
        }
    }

    /**
     * 判断t1树是否包含t2树全部的拓扑结构
     */
    /**
     * 判断树A是否包含树B的拓扑结构
     * @param a
     * @param b
     * @return
     */
    public static boolean contains(TreeNode a, TreeNode b) {
        return checkTreeNode(a.left, b) || checkTreeNode(a, b) || checkTreeNode(a.right, b);
    }

    /**
     * 先序遍历树结点
     * @param a
     * @param b
     * @return
     */
    public static boolean checkTreeNode(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.value != b.value) {
            return false;
        }
        return checkTreeNode(a.left, b.left)
                && checkTreeNode(a.right, b.right);
    }

    /*
    P141、判断t1树中是否有t2树拓扑结构完全相同的子树
    假设t1树有N个结点，t2树有M个结点
    思路1：
    1、对于t1的每个子树，判断它的子树是否和t2的结构完全相同，这个过程是O(M)的时间复杂度
    2、t1的每个结点是O(N)的时间复杂度
    3、总的时间复杂度是O(M * N)
    思路2：
    1、将t1、t2树进行序列化为字符串
    2、通过KMP算法判断t2是否是t1字符串的一个子串
     */

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean treeAPerfectContainsTreeB(TreeNode a, TreeNode b) {
        return check(a, b) ||
                check(a.left, b) ||
                check(a.right, b);
    }

    /**
     * 检查树a是否有与树b拓扑结构完全相同的子树
     * @param a
     * @param b
     * @return
     */
    public static boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if ((a == null && b != null)
                || (a != null && b == null)) {
            return false;
        }

        if (a != null && b != null && a.value != b.value) {
            return false;
        }

        return check(a.left, b.left) && check(a.right, b.right);
    }

    /**
     * 将数组转换为二叉树
     * @param a
     * @return
     */
    public static TreeNode createBinaryTree(int[] a) {
        List<TreeNode> list = new ArrayList<>(a.length);
        for (int i = 0, length = a.length; i < length; i++) {
            list.add(new TreeNode(a[i]));
        }
        // 得到最后一个父节点的下标
        int lastParentIndex = a.length / 2 - 1;
        for (int i = 0; i < lastParentIndex; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }

        list.get(lastParentIndex).left = list.get(lastParentIndex * 2 + 1);
        if (a.length % 2 != 0) {
            list.get(lastParentIndex).right = list.get(a.length - 1);
        }
        return list.get(0);
    }

    /*
    思路2实现
     */

    /**
     * 序列化二叉树
     * @param head
     * @return
     */
    public static String serialBinaryTree(TreeNode head) {
        if (head == null) {
            return "#!";
        }

        String result = String.valueOf(head.value) + "!";
        result += serialBinaryTree(head.left);
        result += serialBinaryTree(head.right);
        return result;
    }

    /**
     * 采用KMP算法匹配字符串
     * @param str
     * @param match
     * @return
     */
    public static int getIndexOf(String str, String match) {
        if (str == null ||
                match == null ||
                str.length() < match.length()) {
            return -1;
        }

        char[] strCharArray = str.toCharArray();
        char[] matchCharArray = match.toCharArray();

        int[] nextArr = getNextArray(matchCharArray);
        int sIndex = 0;
        int mIndex = 0;
        while (sIndex < strCharArray.length && mIndex < matchCharArray.length) {
            if (strCharArray[sIndex] == matchCharArray[mIndex]) {
                sIndex++;
                mIndex++;
            } else if (nextArr[mIndex] == -1) {
                sIndex++;
            } else {
                mIndex = nextArr[mIndex];
            }
        }
        return mIndex == matchCharArray.length ? sIndex - mIndex : -1;
    }

    /**
     * 获取match的next数组
     * @param matchCharArray
     * @return
     */
    public static int[] getNextArray(char[] matchCharArray) {
        if (matchCharArray.length == 1) {
            return new int[] {-1};
        }

        int[] next = new int[matchCharArray.length];
        next[0] = -1;
        next[1] = 0;
        int position = 2;
        int count = 0;
        while (position < next.length) {
            if (matchCharArray[position - 1] == matchCharArray[count]) {
                next[position++] = ++count;
            } else if (count > 0) {
                count = next[count];
            } else {
                next[position++] = 0;
            }
        }
        return next;
    }

    public static boolean checkTree(TreeNode a, TreeNode b) {
        String str = serialBinaryTree(a);
        String match = serialBinaryTree(b);

        return getIndexOf(str, match) != -1 ? true : false;
    }

    public static void main(String[] args) {
        int[] tree1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] tree2 = {2, 4, 5, 8, 9};

        TreeNode head1 = createBinaryTree(tree1);
        TreeNode head2 = createBinaryTree(tree2);
        System.out.println(checkTree(head1, head2));
    }

}
