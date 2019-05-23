package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/22 0022
 */
public class FindSubstring {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // 单词的长度
        int wordLen = words[0].length();
        // 单词的总长度
        int sumWordLen = wordLen * words.length;

        for (int i = 0, length = s.length(); i < length; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> tempMap = new HashMap<>();
            while (right < s.length()) {
                String t = s.substring(right, right + wordLen);
                count++;
                right += wordLen;
                tempMap.put(t, tempMap.getOrDefault(t, 0) + 1);
                // 如果临时存储的单词的个数大于map中存储的个数，不符合题意
                while (tempMap.get(t) > map.get(t)) {
                    count--;
                    String a = s.substring(left, left + wordLen);
                    tempMap.put(a, tempMap.get(a) - 1);
                    left += wordLen;
                }
                if (count == words.length) {
                    result.add(left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "barfoothefoobarman";
        String[] words = {"bar", "foo"};
        System.out.println(findSubstring(a, words));
    }
}
