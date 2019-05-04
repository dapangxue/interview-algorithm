package newcoder.swordrefertooffer;

import java.io.Serializable;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-9
 */
public class SerializeDeserialize {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }

        stringBuilder.append(root.val + ",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        index ++;
        String[] c = str.split(",");
        TreeNode root = null;
        if (!c[index].equals("#")) {
            root = new TreeNode(Integer.parseInt(c[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
