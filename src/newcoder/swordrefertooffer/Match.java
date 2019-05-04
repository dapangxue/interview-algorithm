package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-8
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        // pattern第二个是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*') {
            // *前面的字符和str数字里面的字符相等
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    // 或者*前面是一个点
                    || pattern[patternIndex] == '.' && strIndex != str.length) {
                /*
                * 当模式第二个字符是*，第一个字符匹配时有三种情况
                * 1. str向后移动一位，模式向后移动两位
                * 2. 模式向后移动两位，即忽略x*
                * 3. 由于*可以表示它前面的多个字符出现任意次，所以将str向后移动一位
                */
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex, pattern, patternIndex+2)
                        || matchCore(str, strIndex+1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }
        // pattern第二个不是*

            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (strIndex != str.length && pattern[patternIndex] == '.')) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            } else {
                return false;
            }
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] str = new char[]{'a', 'a'};
        char[] pattern = new char[]{'a', '.'};
        System.out.println(match.match(str, pattern));
    }
}
