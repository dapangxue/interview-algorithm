package interview.zuo.chapter5;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/20 0020
 */
public class PointNewChar {
    public static String pointNewChar(String s, int k) {
        char[] t = s.toCharArray();
        int num = 0;
        // 新字符的表现形式为小写、大写小写、大写大写
        for (int i = k - 1; i >= 0; i--) {
            if (t[i] > 'Z' || t[i] < 'A') {
                break;
            }
            num++;
        }

        if ((num & 1) == 1) {
            return s.substring(k - 1, k + 1);
        }
        if (t[k] < 'a') {
            return s.substring(k, k + 2);
        } else {
            return s.substring(k, k + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pointNewChar("aaABCDEcBCg", 10));
    }
}
