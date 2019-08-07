package InterviewsofAdvance.bytedance;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/24 0024
 */
public class ByteDance {
    public static void main(String[] args) {
        String s = "12345";
        int result = 0;
        int fix = (int) Math.pow(10, s.length() - 1);
        for (int i = 0, length = s.length(); i < length; i++) {
            char t = s.charAt(i);
            int a = t - '1' + 1;
            result += a * fix;
            fix /= 10;
        }

        System.out.println(result);
    }
}
