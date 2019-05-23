package interview.zuo.chapter5;

/**
 * Created with IntelliJ IDEA.
 * 找到字符串的最长无重复子串-P284
 * @author WuXue
 * @date 2019/5/20 0020
 */
public class MaxUnique {
    public static int maxUnique(String s) {
        int[] map = new int[256];
        // 当前子字符串的开头的上一个位置
        int pre = -1;
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }

        int max = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            char t = s.charAt(i);
            pre = Math.max(map[t], pre);
            map[t] = i;
            max = Math.max(max, i - pre);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxUnique("abcabcdefgh"));
    }
}
