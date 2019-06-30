package leetcode.chapter10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/2 0002
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        List<String> l1 = helper(str1);
        List<String> l2 = helper(str2);

        if (l1.size() < l2.size()) {
            for (int i = l1.size() - 1; i >= 0; i--) {
                if (l2.contains(l1.get(i))) {
                    return l1.get(i);
                }
            }
        } else {
            for (int i = l2.size() - 1; i >= 0; i--) {
                if (l1.contains(l2.get(i))) {
                    return l2.get(i);
                }
            }
        }
        return "";
    }

    public List<String> helper(String str) {
        List<String> result = new ArrayList<>();
        // 获取最小的因子
        StringBuilder stringBuilder = new StringBuilder();
        int right = 1;
        while (right <= str.length()) {
            String t = str.substring(0, right);

            if (str.length() % t.length() == 0) {
                for (int i = 1; i <= str.length() / t.length(); i++) {
                    stringBuilder.append(t);
                }
                if (stringBuilder.toString().equals(str)) {
                    result.add(t);
                }
                stringBuilder.delete(0, stringBuilder.length());

            }
            right ++;
        }
        return result;
    }

    public static void main(String[] args) {
        GcdOfStrings g = new GcdOfStrings();
        System.out.println(g.helper("AAAAAAAA"));
    }
}
