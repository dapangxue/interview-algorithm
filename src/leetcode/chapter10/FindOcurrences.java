package leetcode.chapter10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/9 0009
 */
public class FindOcurrences {
    public static String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] a = text.trim().split(" ");
        for (int i = 2; i < a.length; i++) {
            if (a[i - 1].equals(second) && a[i - 2].equals(first)) {
                result.add(a[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("we will we will rock you",
                "we", "will")));
    }
}
