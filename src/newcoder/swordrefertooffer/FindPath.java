package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-3
 */
public class FindPath {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, new ArrayList<>(), root, target);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
                                                 TreeNode root, int target) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            result.add(new ArrayList<>(list));
        }
        if (root.left != null)
            helper(result, list, root.left, target - root.val);

        if (root.right != null)
            helper(result, list, root.right, target - root.val);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        FindPath findPath = new FindPath();
        System.out.println(findPath.FindPath(treeNode1, 19));
    }
}
