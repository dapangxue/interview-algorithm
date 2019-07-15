package leetcode.chapter9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 二叉树的垂序遍历 https://leetcode-cn.com/articles/vertical-order-traversal-of-a-binary-tree/
 *
 * @author WuXue
 * @date 2019/6/4 0004
 */
public class VerticalTraversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class Location implements Comparable<Location> {
        int x;
        int y;
        int value;

        public Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Location o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else if (this.y != o.y) {
                return o.y - this.y;
            } else {
                return this.value - o.value;
            }
        }
    }

    private static List<Location> list = new ArrayList<>();

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, 0);

        Collections.sort(list);

        int prev = list.get(0).x;
        result.add(new ArrayList<>());
        for (Location loc : list) {
            if (loc.x != prev) {
                prev = loc.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(loc.value);
        }
        return result;
    }

    /**
     * 将树节点构造为Location存入集合中
     * @param root
     * @param x
     * @param y
     */
    public static void helper(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        list.add(new Location(x, y, root.value));
        helper(root.left, x - 1, y - 1);
        helper(root.right, x + 1, y - 1);
    }

    /**
     * 构建一个完全二叉树
     * @param a
     * @return
     */
    public static TreeNode createBinaryTree(int[] a) {
        List<TreeNode> list = new ArrayList<>(a.length);
        for (int i = 0, length = a.length; i < length; i ++) {
            list.add(new TreeNode(a[i]));
        }

        int lastParentTreeNodeIndex = a.length / 2 - 1;
        for (int i = 0; i < lastParentTreeNodeIndex; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }

        list.get(lastParentTreeNodeIndex).left = list.get(2 * lastParentTreeNodeIndex + 1);
        if ((a.length & 1) == 1) {
            list.get(lastParentTreeNodeIndex).right = list.get(2 * lastParentTreeNodeIndex + 2);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode head = createBinaryTree(a);
        System.out.println(verticalTraversal(head));
    }

}
