package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-3
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str.length() <= 0 || str.isEmpty()) {
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        return str2 + str1;
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        System.out.println(leftRotateString.LeftRotateString("abcdefg", 2));
    }
}
