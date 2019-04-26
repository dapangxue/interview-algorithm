package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-2
 */
public class PrintFromTopToBottom {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        // treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode treeNode8 = null;

        PrintFromTopToBottom printFromTopToBottom = new PrintFromTopToBottom();
        System.out.println(printFromTopToBottom.PrintFromTopToBottom(treeNode8));
    }
}
