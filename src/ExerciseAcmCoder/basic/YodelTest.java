package ExerciseAcmCoder.basic;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 18-12-20
 */
public class YodelTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 约德尔人历史的字符串
        String a = scanner.nextLine();
        // 黑默丁格观测星空得到的字符串。
        String b = scanner.nextLine();
        int count = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, length = a.length(); i < length; i++) {
            if (Character.	isLetterOrDigit(a.charAt(i))) {
                // stringBuilder.append('1');
                if (b.charAt(i) == '1') {
                    count++;
                }
            } else {
                if (b.charAt(i) == '0') {
                    count++;
                }
                // stringBuilder.append('0');
            }
        }
        // System.out.println(stringBuilder.toString());
        float out = (float) count * 100 / (float) a.length();
        System.out.printf("%.2f%%", out);
    }
}
