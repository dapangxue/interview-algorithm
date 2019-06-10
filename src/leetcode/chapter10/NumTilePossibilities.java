package leetcode.chapter10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/9 0009
 */
public class NumTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }

        // 题目说明1 <= tiles.length <= 7
        Set<String>[] sets = new Set[7];
        for (int i = 0; i < 7; i++) {
            sets[i] = new HashSet<>();
        }

        int[] result = new int[1];
        // 统计每个字符出现了多少次
        int[] num = new int[26];
        for (int i = 0, length = tiles.length(); i < length; i++) {
            num[tiles.charAt(i) - 'A']++;
        }

        String s = "";
        for (int i = 0; i < 26; i++) {
            if (num[i] == 0) {
                continue;
            }

            num[i]--;
            dfs(num, result, sets, s + (char) (i + 'A'));
            num[i]++;
        }

        return result[0];
    }

    /**
     * 采用dfs
     * @param num 统计各个字符有多少个的集合
     * @param len 生成字符串的长度
     * @param sets 各个长度字符串的集合
     * @param s
     */
    public static void dfs(int[] num, int[] result, Set[] sets, String s) {
        if (sets[s.length() - 1].contains(s)) {
            return;
        }

        result[0] ++;
        sets[s.length() - 1].add(s);
        for (int i = 0; i < 26; i++) {
            if (num[i] == 0) {
                continue;
            }

            num[i] --;
            dfs(num, result, sets, s + (char) (i + 'A'));
            num[i] ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("YYXBTSR"));
    }
}
