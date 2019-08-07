package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class HasSubtree {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断B树是否是A树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                flag = helper(root1, root2);
            }
            if (flag == false) {
                flag = hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
            }
        }
        return flag;
    }

    /**
     * 如果B树的根节点和A树的某个子节点相等，以B树的节点为依托，继续判断和A树的对应节点是否值相等
     * @param root1
     * @param root2
     * @return
     */
    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
