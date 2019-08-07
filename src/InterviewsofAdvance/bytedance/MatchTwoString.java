package InterviewsofAdvance.bytedance;

/**
 * Created with IntelliJ IDEA.
 * 算法题：给出两个字符串s1, s2，判断s1中是否存在s2的某个排列。其实只要记录一下s2的所有字符出现次数，
 *
 * @author WuXue
 * @date 2019/7/22 0022
 */
public class MatchTwoString {
    public static boolean matchTwoString(String str1, String str2) {
        // 建立一个map存储str2中每个字符出现的次数
        int[] map = new int[26];
        // 处理str2
        for (int i = 0, length = str2.length(); i < length; i++) {
            map[str2.charAt(i) - 'a']++;
        }

        int[] strMap = new int[26];
        // 通过滑动窗口进行str1和str2的匹配
        for (int i = 0, length = str1.length(); i < length; i++) {
            if (i < str2.length() - 1) {
                strMap[str1.charAt(i) - 'a']++;
            } else if (i == str2.length() - 1) {
                strMap[str1.charAt(i) - 'a']++;
                if (match(map, strMap)) {
                    return true;
                }
            } else {
                strMap[str1.charAt(i - str2.length()) - 'a']--;
                strMap[str1.charAt(i) - 'a']++;
                if (match(map, strMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean match(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcdrfg";
        String str2 = "gr";
        System.out.println(matchTwoString(str1, str2));
    }
}
