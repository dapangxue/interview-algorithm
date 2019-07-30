package leetcode.chapter2;

/**
 * Created with IntelliJ IDEA.
 * 基于数组实现前缀树
 * @author WuXue
 * @date 2019/7/30 0030
 */
public class WordDictionary {

    class TrieNode {

        /**
         * 当前节点的连接
         */
        TrieNode[] links;

        boolean end;

        boolean state;

        public TrieNode() {
            links = new TrieNode[26];
        }

        /**
         * 判断当前字符在当前节点是否存在
         * @param ch
         * @return
         */
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            end = true;
        }

        public boolean isEnd() {
            return end;
        }

        /**
         * 如果当前节点有值装入
         */
        public void setState() {
            state = true;
        }

        public boolean getState() {
            return state;
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入一个字符串
         * @param word
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0, length = word.length(); i < length; i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        /**
         * 查询前缀树是否word字符串
         * @param word
         * @return
         */
        public boolean searchPrefix(String word) {
            TrieNode node = root;
            return searchPrefix(word, 0, node);
        }

        /**
         * 查找从index索引开始的字符串是否在后续的前缀树中匹配
         * @param word
         * @param index
         * @param node
         * @return
         */
        public boolean searchPrefix(String word, int index, TrieNode node) {

            // 如果当前节点为null，那么不需要后续的查询，返回false
            if (node == null) {
                return false;
            }
            if (index == word.length()) {
                return node.isEnd();
            }

            char currentChar = word.charAt(index);
            // 如果是正则表达式字符
            if (currentChar == '.') {
                // 那么从a~z作为前缀，继续查找后续的字符串
                for (char i = 'a'; i <= 'z'; i++) {
                    // 查看当前节点是否有指向下一节点的链接
                    TrieNode nextNode = node.get(i);
                    index++;
                    if (nextNode != null) {
                        if (searchPrefix(word, index, nextNode)) {
                            return true;
                        }
                    }
                    index--;
                }
                return false;
            } else {
                TrieNode nextNode = node.get(currentChar);
                if (nextNode == null) {
                    return false;
                } else {
                    return searchPrefix(word, ++index, nextNode);
                }
            }
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        if (!trie.searchPrefix(word)) {
            trie.insert(word);
        }
    }

    public boolean search(String word) {
        return trie.searchPrefix(word);
    }

}
