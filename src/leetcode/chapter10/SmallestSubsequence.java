package leetcode.chapter10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/10 0010
 */
public class SmallestSubsequence {
    public static String smallestSubsequence(String text) {
        int[] count = new int[26];
        for (int i = 0, length = text.length(); i < length; i++) {
            count[text.charAt(i) - 'a'] ++;
        }

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = text.length(); i < length; i++) {
            if (set.contains(text.charAt(i))) {
                count[text.charAt(i) - 'a'] --;
                continue;
            }

            while (sb.length() != 0 && sb.charAt(sb.length() - 1) > text.charAt(i) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                set.remove(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(text.charAt(i));
            set.add(text.charAt(i));
            count[text.charAt(i) - 'a'] --;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestSubsequence("leetcode"));
    }
}
