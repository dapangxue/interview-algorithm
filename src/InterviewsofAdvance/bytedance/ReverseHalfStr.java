package InterviewsofAdvance.bytedance;

/**
 * Created with IntelliJ IDEA.
 * 字符串逆置，后半部分逆置，前半部分按序输出
 * @author WuXue
 * @date 2019/7/22 0022
 */
public class ReverseHalfStr {

    public static String reverseHalfStr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        System.out.println(str);

        StringBuilder stringBuilder = new StringBuilder(str);
        int left = stringBuilder.length() / 2;
        int right = stringBuilder.length() - 1;
        while (left < right) {
            char t = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left, stringBuilder.charAt(right));
            stringBuilder.setCharAt(right, t);
            left++;
            right--;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "abcdef";
        System.out.println(reverseHalfStr(a));
    }

}
