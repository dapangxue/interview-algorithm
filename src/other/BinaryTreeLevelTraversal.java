package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * 二叉树的层次遍历
 * 要求：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author WuXue
 * @date 2019/6/8 0008
 */
public class BinaryTreeLevelTraversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public List<Integer> binaryTreeLevelTraversal(TreeNode head) {
        List<Integer> result = new ArrayList<>();

        if (head != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(head);
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                result.add(t.value);
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> binaryTreeLevelTraversal1(TreeNode head) {
        List<List<Integer>> result = new ArrayList<>();
        if (head != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(head);
            int cnt = 1;

            while (!q.isEmpty()) {
                // 说明需要遍历这一层有多少个结点
                int num = cnt;
                cnt = 0;
                List<Integer> list = new ArrayList<>();

                // 将这一层结点加入list,并且统计下一层结点的个数
                for (int i = 1; i <= num; i++) {
                    TreeNode t = q.poll();
                    if (t.left != null) {
                        q.offer(t.left);
                        cnt++;
                    }
                    if (t.right != null) {
                        q.offer(t.right);
                        cnt++;
                    }
                    list.add(t.value);
                }
                result.add(list);
            }
        }
        return result;
    }
}
