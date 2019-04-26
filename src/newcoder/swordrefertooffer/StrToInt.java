package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-7
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str.length() == 0 ||
                (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-'))) {
            return 0;
        } else {
            char[] array = str.toCharArray();
            // 定义字符串转数字的符号标志位
            boolean isPositive = true;
            int i = 0;

            if (array[0] == '+') {
                i++;
            } else if (array[0] == '-') {
                isPositive = false;
                i++;
            }

            int result = 0;
            boolean error = false;
            for (int j = i, length = array.length; j < length; j++) {
                if (array[j] >= '0' && array[j] <= '9') {
                    result = result * 10 + (array[j] - '0');
                } else {
                    error = true;
                    break;
                }
            }
            if (!error) {
                if (isPositive) {
                    return result;
                } else {
                    return result * -1;
                }
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.StrToInt("123"));
    }
}
