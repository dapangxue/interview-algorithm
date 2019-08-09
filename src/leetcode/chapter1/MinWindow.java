package leetcode.chapter1;

import javafx.util.Pair;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * leetcode-76 最小覆盖子串
 * @author WuXue
 * @date 2019/8/8 0008
 */
public class MinWindow {
    /**
     * version1
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 统计字符串t的每个字符有多少个
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = tCharCount.getOrDefault(t.charAt(i), 0);
            tCharCount.put(t.charAt(i), count + 1);
        }

        Map<Character, Integer> sCharCount = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;
        // left right len
        int[] reuslt = new int[3];
        reuslt[0] = 0;
        reuslt[1] = 0;
        reuslt[2] = -1;

        while (right < s.length()) {
            char f = s.charAt(right);
            int count = sCharCount.getOrDefault(f, 0);
            sCharCount.put(f, count + 1);

            // 如果当前子串字符对应的个数和目标串字符对应的个数相等，说明已经匹配一个字符
            if (tCharCount.containsKey(f) && sCharCount.get(f).equals(tCharCount.get(f))) {
                formed++;
            }

            while (left <= right && formed == tCharCount.size()) {
                f = s.charAt(left);
                // 记录下最小的窗口
                if (reuslt[2] == -1 || right - left + 1 < reuslt[2]) {
                    reuslt[0] = left;
                    reuslt[1] = right;
                    reuslt[2] = right - left + 1;
                }

                sCharCount.replace(f, sCharCount.get(f) - 1);
                if (left <= right && tCharCount.containsKey(f) && sCharCount.get(f).intValue() < tCharCount.get(f).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return reuslt[2] == -1 ? "" : s.substring(reuslt[0], reuslt[1] + 1);
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow2(String s, String t) {
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0, length = t.length(); i < length; i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        List<Pair<Character, Integer>> list = new ArrayList<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            char x = s.charAt(i);
            if (dictT.containsKey(x)) {
                list.add(new Pair<>(x, i));
            }
        }

        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] result = new int[3];
        result[0] = 0;
        result[1] = 0;
        result[2] = -1;

        while (right < list.size()) {
            char c = list.get(right).getKey();

            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count + 1);

            if (dictT.get(c).intValue() == windowCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == dictT.size()) {
                c = list.get(left).getKey();

                int start = list.get(left).getValue();
                int end = list.get(right).getValue();
                if (result[2] == -1 || result[2] > end - start + 1) {
                    result[0] = start;
                    result[1] = end;
                    result[2] = end - start + 1;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (left <= right && windowCount.get(c) < dictT.get(c)) {
                    formed--;
                }

                left ++;
            }
            right ++;
        }
        return result[2] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow2("ABCDFG", "AG"));
    }
}
