package interview.zuo.chapter9;

/**
 * Create by IDEA
 * 左程云算法第九章-P491
 * KMP算法
 * @author wuxue
 * @date 19-5-6
 */
public class KMP {
    /*
    假设有两个字符串str = "aaaaaaaaaaaab"和match = "aaaab"
    如果按照常规的思路，首先从str[0]开始和match[0]慢慢匹配，
    到str[4] = 'a'和match[4] = 'b'时发现不相等，那么需要重新从str[1]开始匹配
    这样的每次匹配match可能的成本是O(M)M为match的长度
    需要匹配N次，N是str的长度，总的时间复杂度为O(N * M)
     */
    /**
     * 采用KMP算法可以将时间复杂度降低到O(N)
     * 建立一个nextArr数组，nextArr数组的长度和match的长度一样
     * nextArr[i]表示match[i]中以i-1结尾的后缀字符串和以0开头的前缀字符串的最大匹配
     */

    public static int getIndexOf(String s, String match) {
        if (s == null || match == null || match.length() < 1 || s.length() < match.length()) {
            return -1;
        }

        char[] sCharArray = s.toCharArray();
        char[] matchCharArray = match.toCharArray();

        int sIndex = 0;
        int mIndex = 0;
        int[] nextArr = getNextArray(matchCharArray);

        while (sIndex < sCharArray.length &&
                mIndex < matchCharArray.length) {
            if (sCharArray[sIndex] == matchCharArray[mIndex]) {
                sIndex++;
                mIndex++;
            } else if (nextArr[mIndex] == -1) {
                sIndex++;
            } else {
                mIndex = nextArr[mIndex];
            }
        }
        return mIndex == matchCharArray.length ? sIndex - mIndex : -1;
    }

    /**
     * 获取最大匹配数组
     * @param match
     * @return
     */
    public static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[] {-1};
        }

        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int position = 2;
        // 前缀字符串和后缀字符串匹配的最大长度
        int cn = 0;
        while (position < next.length) {
            if (match[position - 1] == match[cn]) {
                next[position++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[position++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaab";
        String match = "aaaab";
        System.out.println(getIndexOf(str, match));
    }
}
