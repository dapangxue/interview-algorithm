package other;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * 本题采用哈夫曼编码实现
 * @author WuXue
 * @date 2019/7/30 0030
 */
public class HaffmanEncode {

    class TreeNode implements Comparable<TreeNode> {
        // 当前字符出现的频次
        int count;

        // 字符
        char ch;
        TreeNode left;
        TreeNode right;

        @Override
        public int compareTo(TreeNode o) {
            if (this.count != o.count) {
                return this.count - o.count;
            } else {
                return this.ch - o.ch;
            }
        }
    }

    /**
     * 保存字符和字符出现频次的关系
     */
    private Map<Character, Integer> characterIntegerMap = new HashMap<>();
    private PriorityQueue<TreeNode> queue = new PriorityQueue<>();
    private Map<Character, String> chEncodeMap = new HashMap<Character, String>();
    private Map<String, Character> encodeChMap = new HashMap<>();

    /**
     * 对字符串进行预处理
     * @param s
     */
    public void init(String s) {
        char[] sToChar = s.toCharArray();
        for (int i = 0, length = sToChar.length; i < length; i++) {
            char t = sToChar[i];
            if (!characterIntegerMap.containsKey(t)) {
                characterIntegerMap.put(t, 1);
            } else {
                characterIntegerMap.put(t, characterIntegerMap.get(t) + 1);
            }
        }

        // 将map中的值传入优先队列
        characterIntegerMap.forEach((ch, count) -> {
            TreeNode newNode = new TreeNode();
            newNode.count = count;
            newNode.ch = ch;
            queue.offer(newNode);
        });
    }

    /**
     * 将队列中的元素处理成哈夫曼树
     * @return
     */
    public TreeNode createHaffman() {
        TreeNode root = null;
        while (queue.size() > 1) {
            // 首先从队列中取出权重最小的两个点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 将它们的权重相加赋给一个新节点
            int count = left.count + right.count;
            root = new TreeNode();
            root.count = count;
            root.left = left;
            root.right = right;
            queue.offer(root);
        }
        return root;
    }

    public void encode(TreeNode root) {
        encode(root, "");
    }

    /**
     * 深度优先遍历
     * @param node
     * @param encode
     */
    public void encode(TreeNode node, String encode) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                chEncodeMap.put(node.ch, encode.toString());
                encodeChMap.put(encode.toString(), node.ch);
            }
            encode(node.left, encode + "0");
            encode(node.right, encode + "1");
        }
    }

    /**
     * 根据压缩码解析出字符串
     * @param encodeCode
     * @return
     */
    public String decode(String encodeCode) {
        if (encodeCode == null || encodeCode.length() == 0) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        int left = 0;
        int right = 0;
        while (left < encodeCode.length()) {
            String subCode = encodeCode.substring(left, right);
            if (encodeChMap.containsKey(subCode)) {
                result.append(encodeChMap.get(subCode));
                left = right;
            } else {
                right ++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String word = "wuwuaabbcc";
        HaffmanEncode a = new HaffmanEncode();
        a.init(word);
        TreeNode root = a.createHaffman();
        a.encode(root);
        a.chEncodeMap.forEach((c,s) -> System.out.println("key : " + c + " value : " + s));
        System.out.println(a.decode("000111011110"));
    }

}
