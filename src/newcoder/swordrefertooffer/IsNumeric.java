package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-8
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) {
            return false;
        }

        boolean hasSign = false, hasE = false, hasPoint = false;
        for (int i = 0, length = str.length; i < length; i++) {
            // 查看字符里面是否带E
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第一次出现正负号，如果不在开头，就必须在e/E之后
                if (!hasSign && i != 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                if (hasSign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                hasSign = true;
            } else if (str[i] == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsNumeric isNumeric = new IsNumeric();
        char[] str = new char[]{'0', '.', '-', '1', '2', '3'};
        System.out.println(isNumeric.isNumeric(str));
    }
}
