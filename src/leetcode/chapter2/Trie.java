package leetcode.chapter2;

/**
 * Created with IntelliJ IDEA.
 * leetcode 208题 Trie前缀树
 * @author WuXue
 * @date 2019/7/29 0029
 */
public class Trie {

    class TrieNode {

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 单词的插入
     * @param word 需要插入的单词
     */
    public void insert(String word) {
        // 每次的插入先从根节点开始找起
        TrieNode node = root;
        for (int i = 0, length = word.length(); i < length; i++) {
            char currentChar = word.charAt(i);
            if (!node.containKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0, length = word.length(); i < length; i ++) {
            char currentChar = word.charAt(i);
            if (node.containKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * 搜索Trie树种是否有这个单词
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * 查找一个单词是不是前缀
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
