package newcoder.swordrefertooffer;

import newcoder.baidu.first.Solution;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 18-12-31
 */
public class ReConstructBinaryTree {
    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length) {
            return null;
        }
        return helper(pre, in, 0 , 0, pre.length);
    }

    private TreeNode helper(int[] pre, int[] in, int startPre, int startIn, int n) {
        TreeNode root = null;
        if (n > 0) {
            root = new TreeNode(pre[startPre]);
            int i = 0;
            for (; i < n; i++) {
                if (in[startIn + i] == root.val) {
                    break;
                }
            }
            root.left = helper(pre, in, startPre+1, startIn, i);
            root.right = helper(pre, in, startPre+i+1, startIn+i+1, n-i-1);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] order = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        reConstructBinaryTree.reConstructBinaryTree(pre, order);
    }
}
