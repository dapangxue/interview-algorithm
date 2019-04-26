package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 * 题目来源：网易2018校招https://www.nowcoder.com/practice/3fbd8fe929ea4eb3a254c0ed34ac993a?tpId=90&tqId=30782&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author wuxue
 * @date 19-2-12
 */
public class Interlace01string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取输入的01串
        String s = scanner.nextLine();

        int max = 1, len = 1;

        char[] c = s.toCharArray();
        for (int i = 1, length = c.length; i < length; i++) {
            if (c[i] != c[i-1]) {
                len++;
                if (len > max) {
                    max = len;
                }
            } else {
                len = 1;
            }
        }
        System.out.println(max);
    }
}
