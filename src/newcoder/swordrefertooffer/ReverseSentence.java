package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-4
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str.length() <= 0 || str.trim().equals("")) {
            return str;
        }
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuilder.append(strings[i]);
                break;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    //完成翻转功能
    private void reverse(char[] c,int begin,int end) {
        while (begin < end) {
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;

            begin++;
            end--;
        }
    }

    public String ReverseSentence1(String str) {
        if (str.length() <= 0 || str.trim().equals("")) {
            return str;
        }

        char[] c = str.toCharArray();
        reverse(c, 0, c.length-1);
        int head = 0, end = 0;
        while (head < c.length) {
            // 空字符不反转
            if (c[head] == ' ') {
                head++;
                end++;
            } else if (c[end] == ' ') {
                reverse(c, head, --end);
                head = ++end;
            } else if (end == c.length-1) {
                reverse(c, head, end);
                head = ++end;
            } else {
                end++;
            }
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.ReverseSentence1("i AM A SHUDENT"));
    }
}
