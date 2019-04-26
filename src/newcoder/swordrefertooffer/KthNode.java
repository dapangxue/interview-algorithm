package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-10
 */
public class KthNode {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        midOrder(pRoot, list);
        return k > list.size() ? null : list.get(k-1);
    }

    private void midOrder(TreeNode pRoot, List<TreeNode> list) {
        if (pRoot == null) {
            return;
        }
        midOrder(pRoot.left, list);
        list.add(pRoot);
        midOrder(pRoot.right, list);
    }
}
