package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * 左程云算法P95-打印二叉树的边界结点
 * @author WuXue
 * @date 2019/5/2 0002
 */
public class PrintBinaryTreeEdge {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 按照标准1打印二叉树的边界结点
     * 思路：
     * 1、得到二叉树的每一层最左和最右的结点
     * 2、从上到下打印最左边的结点
     * 3、前序遍历二叉树，打印叶子节点中不是最左和最右的结点
     * 4、从下到上打印最右侧的结点
     * @param head
     */
    public static void printEdge(TreeNode head) {
        if (head == null) {
            return;
        }
        // 获取二叉树的高度
        int height = getTreeHeight(head);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head, 0, edgeMap);

        // 1、从上往下打印最左边的结点
        for (int i = 0; i < height; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        printLeafNotInMap(head, 0, edgeMap);
        for (int i = height - 1; i >= 0; i--) {
            if (edgeMap[i][1] != edgeMap[i][0]) {
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
    }

    /**
     * 获取二叉树的高度(方法1)
     * @param head
     * @return
     */
    public static int getTreeHeight(TreeNode head, int height) {
        if (head == null) {
            return height;
        }

        return Math.max(getTreeHeight(head.left, height + 1),
                getTreeHeight(head.right, height + 1));
    }

    /**
     * 获取二叉树的高度(方法2)
     * @param head
     * @return
     */
    public static int getTreeHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int left = getTreeHeight(head.left);
        int right = getTreeHeight(head.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 获取一个二叉树的最左节点和最右节点（精髓）
     * @param head
     * @param level
     * @param edgeMap
     */
    public static void setEdgeMap(TreeNode head, int level, TreeNode[][] edgeMap) {
        if (head == null) {
            return;
        }

        edgeMap[level][0] = edgeMap[level][0] == null ? head : edgeMap[level][0];
        edgeMap[level][1] = head;
        setEdgeMap(head.left, level + 1, edgeMap);
        setEdgeMap(head.right, level + 1, edgeMap);
    }

    /**
     * 打印叶子节点中不是最左和最右的结点
     * @param head
     * @param level
     * @param edgeMap
     */
    public static void printLeafNotInMap(TreeNode head, int level, TreeNode[][] edgeMap) {
        if (head == null) {
            return;
        }

        if (head.left == null && head.right == null && head != edgeMap[level][0] && head != edgeMap[level][1]) {
            System.out.print(head.value + " ");
        }

        printLeafNotInMap(head.left, level + 1, edgeMap);
        printLeafNotInMap(head.right, level + 1, edgeMap);
    }

    /**
     * 通过一个数组创建二叉树（满二叉树/完全二叉树）
     * @param a
     * @return
     */
    public static TreeNode createBinaryTree(int[] a) {
        List<TreeNode> list = new ArrayList<>(a.length);
        for (int i = 0, length = a.length; i < length; i++) {
            list.add(new TreeNode(a[i]));
        }

        // 获取最后一个父节点的下标
        int lastParentTreeNodeIndex = a.length / 2 - 1;
        for (int i = 0; i < lastParentTreeNodeIndex; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }

        list.get(lastParentTreeNodeIndex).left = list.get(2 * lastParentTreeNodeIndex + 1);
        if (a.length % 2 != 0) {
            list.get(lastParentTreeNodeIndex).right = list.get(2 * lastParentTreeNodeIndex + 2);
        }
        return list.get(0);
    }

    /**
     * 非递归的方式前序遍历打印二叉树
     * @param head
     * @return
     */
    public static List<Integer> preOrder(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
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
        int[] a = {-3, 3, -9, 1, 0, 2, 1, 1, 2, 1, 6};
        TreeNode head = createBinaryTree(a);
        System.out.println(preOrder(head));
        System.out.println(getTreeHeight(head));
        System.out.println(getTreeHeight(head, 0));
        printEdge(head);
    }
}
