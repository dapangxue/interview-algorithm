package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/16 0016
 */
public class PrintByLevel {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void printByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nextLevelLast = null;

        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.print(t.val + " ");
            if (t.left != null) {
                queue.offer(t.left);
                nextLevelLast = t.left;
            }

            if (t.right != null) {
                queue.offer(t.right);
                nextLevelLast = t.right;
            }

            if (t == last) {
                System.out.println("left - right : ");
                last = nextLevelLast;
            }
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当前层的最右节点
        TreeNode last = root;
        // 下一层的最右节点
        TreeNode nextLevelNode = null;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            list.add(t.val);
            if (t.left != null) {
                queue.offer(t.left);
                nextLevelNode = t.left;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nextLevelNode = t.right;
            }

            if (t == last) {
                result.add(new ArrayList<>(list));
                list.clear();
                last = nextLevelNode;
            }
        }
        return result;
    }
}
