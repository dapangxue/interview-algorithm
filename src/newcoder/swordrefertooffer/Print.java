package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-9
 */
public class Print {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            // 偶数层
            if ((layer & 1) == 0) {
                ArrayList<Integer> s2 = new ArrayList<>();
                ArrayList<TreeNode> temp = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode p =queue.poll();
                    temp.add(p);
                    s2.add(p.val);
                }
                while (!temp.isEmpty()) {
                    TreeNode c = temp.remove(temp.size()-1);
                    if (c.left != null) {
                        queue.offer(c.left);
                    }
                    if (c.right != null) {
                        queue.offer(c.right);
                    }
                }
                list.add(new ArrayList<>(s2));
                layer++;
            } else {
                // 奇数层
                // 用来存放奇数层的结点的值
                ArrayList<Integer> s1 = new ArrayList<>();
                ArrayList<TreeNode> temp = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    temp.add(p);
                    s1.add(p.val);
                }
                while (!temp.isEmpty()) {
                    TreeNode c = temp.remove(temp.size()-1);
                    if (c.right != null) {
                        queue.offer(c.right);
                    }
                    if (c.left != null) {
                        queue.offer(c.left);
                    }
                }
                list.add(new ArrayList<>(s1));
                layer++;
            }
        }
        return list;
    }
}
