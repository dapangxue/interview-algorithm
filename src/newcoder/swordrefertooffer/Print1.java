package newcoder.swordrefertooffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-9
 */
public class Print1 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<TreeNode> temp = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                arrayList.add(p.val);
                temp.add(p);
            }

            while (!temp.isEmpty()) {
                TreeNode c = temp.remove(0);
                if (c.left != null) {
                    queue.offer(c.left);
                }
                if (c.right != null) {
                    queue.offer(c.right);
                }
            }

            list.add(new ArrayList<>(arrayList));
        }
        return list;
    }

    ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.left!=null){
                layer.add(cur.left);
            }
            if(cur.right!=null){
                layer.add(cur.right);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
