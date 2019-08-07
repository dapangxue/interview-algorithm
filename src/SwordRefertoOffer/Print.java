package SwordRefertoOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/20 0020
 */
public class Print {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot != null) {
            // 定义一个队列存储二叉树的节点
            Queue<TreeNode> queue = new LinkedList<>();
            // 每一行的最右边节点
            TreeNode lineLastNode = pRoot;
            // 下一行的最右边节点
            TreeNode nextLineLastNode = null;
            queue.offer(pRoot);
            ArrayList<Integer> list = new ArrayList<>();

            while (!queue.isEmpty()) {
                // 从队列中拿出当前节点
                TreeNode t = queue.poll();
                list.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                    nextLineLastNode = t.left;
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    nextLineLastNode = t.right;
                }
                // 如果当前节点为当前行的最右边节点
                if (t == lineLastNode) {
                    // 更新最右节点
                    lineLastNode = nextLineLastNode;
                    result.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return result;
    }
}
