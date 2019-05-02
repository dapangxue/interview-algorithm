package interview.zuo.chapter3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/2 0002
 */
public class BinaryTreeMaxLength {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 在二叉树中找到累加和为指定值的最长路径长度
     * @param head 二叉树头结点
     * @param k 给定值
     * @return 最大长度
     */
    public static int getMaxLength(TreeNode head, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 表示和为0的时候，为第0层
        map.put(0, 0);
        int length = getMaxLength(head, map, k, 1, 0, 0);
        return length;
    }

    /**
     * @param head
     * @param map
     * @param k
     * @param level
     * @param maxLen
     * @param preSum
     * @return
     */
    public static int getMaxLength(TreeNode head, Map<Integer, Integer> map,
                            int k, int level, int maxLen, int preSum) {
        if (head == null) {
            return maxLen;
        }

        int currentSum = preSum + head.value;
        if (!map.containsKey(currentSum)) {
            map.put(currentSum, level);
        }

        if (map.containsKey(currentSum - k)) {
            maxLen = Math.max(maxLen, level - map.get(currentSum - k));
        }

        maxLen = getMaxLength(head.left, map, k, level + 1, maxLen, currentSum);
        maxLen = getMaxLength(head.right, map, k, level + 1, maxLen, currentSum);

        if (map.containsKey(currentSum) && level == map.get(currentSum)) {
            map.remove(currentSum);
        }
        return maxLen;
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

    /**
     * 非递归的方式前序遍历二叉树
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
        TreeNode head  = createBinaryTree(a);
        System.out.println(getMaxLength(head, -9));
        System.out.println(preOrder(head));
    }
}
