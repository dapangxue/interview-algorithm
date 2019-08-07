package SwordRefertoOffer;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 二叉树的序列化和反序列化
 * @author WuXue
 * @date 2019/7/20 0020
 */
public class SerializeDeserialize {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int index = -1;

     static String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            return "#!";
        }
        stringBuilder.append(root.val + "!");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    static TreeNode Deserialize(String str) {
        String[] s = str.split("!");
        index++;
        if (!s[index].equals("#")) {
            TreeNode root = new TreeNode(Integer.valueOf(s[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
            return root;
        }
        return null;
    }

    public static TreeNode createBalanceBinaryTree(int[] array) {
        int length = array.length;
        List<TreeNode> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(new TreeNode(array[i]));
        }

        int lastParentTreeNodeIndex = length / 2 - 1;
        for (int i = 0; i < lastParentTreeNodeIndex; i++) {
            list.get(i).left = list.get(i * 2 + 1);
            list.get(i).right = list.get(i * 2 + 2);
        }

        list.get(lastParentTreeNodeIndex).left = list.get(lastParentTreeNodeIndex * 2 + 1);
        if ((length & 1) == 1) {
            list.get(lastParentTreeNodeIndex).right = list.get(lastParentTreeNodeIndex * 2 + 2);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11};
        System.out.println(Serialize(createBalanceBinaryTree(a)));
    }
}
