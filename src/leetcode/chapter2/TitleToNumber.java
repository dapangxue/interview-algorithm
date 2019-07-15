package leetcode.chapter2;

/**
 * Created with IntelliJ IDEA.
 * leetcode-171
 * https://leetcode-cn.com/problems/excel-sheet-column-number/submissions/
 * @author WuXue
 * @date 2019/6/13 0013
 */
public class TitleToNumber {

    public static int titleToNumber(String s) {

        /*
        可以看做是一个26进制的数转为十进制的数
        位权为26
         */
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
