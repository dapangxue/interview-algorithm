import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        StringBuffer s = new StringBuffer("we are happy");
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(StringBuffer str) {
        int countSpace = 0;
        // 统计空格的个数
        for (int i = 0, length = str.length(); i < length; i++) {
            if (str.charAt(i) == ' ') {
                countSpace ++;
            }
        }
        // 新的字符串的长度
        int strNewLength = str.length() + countSpace * 2;
        // StringBuffer stringBuffer = new StringBuffer(strNewLength);
        // stringBuffer.append(str);
        int p1 = str.length() - 1;
        int p2 = strNewLength - 1;
        // stringBuffer.setLength(strNewLength);
        str.setLength(strNewLength);
        for (int i = p1; i >= 0; i--) {
            char temp = str.charAt(i);
            if (temp == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');

            } else {
                str.setCharAt(p2--, temp);
            }
        }
        return str.toString();
    }
}
