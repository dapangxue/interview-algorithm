package InterviewsofAdvance.bytedance;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/22 0022
 */
public class Mirror {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode t = root.left;
        root.left = root.right;
        root.right = root.left;
    }
}
