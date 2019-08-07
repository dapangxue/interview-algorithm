package SwordRefertoOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/20 0020
 */
public class KthNode {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
        // 对二叉搜索树执行一直中序遍历
        List<TreeNode> list = new ArrayList<>();
        if (pRoot != null) {
            Stack<TreeNode> stack = new Stack<>();
            // pRoot指当前节点
            while (!stack.isEmpty() || pRoot != null) {
                if (pRoot != null) {
                    stack.push(pRoot);
                    pRoot = pRoot.left;
                } else {
                    pRoot = stack.pop();
                    list.add(pRoot);
                    pRoot = pRoot.right;
                }
            }
            return list.get(k - 1);
        }
        return null;
    }
}
