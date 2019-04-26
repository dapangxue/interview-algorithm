package ExerciseAcmCoder.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 18-12-18
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int len = scanner.nextInt();
            int[] nums = new int[len];
            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = scanner.nextInt();
                copy[i] = nums[i];
            }

            // 将nums数组排序
            Arrays.sort(nums);
            // 数组降序片段的下标
            int start = 0, end = len-1;
            // 查找数组降序的片段
            for (int j = 0; j < len; j++) {
                if (nums[j] != copy[j]) {
                    start = j;
                    break;
                }
            }
            for (int k = len-1; k >= 0; k--) {
                if (nums[k] != copy[k]) {
                    end = k;
                    break;
                }
            }
            // System.out.println("start = " + start + " end = " + end);
            for (int l = start; l <= end; l++) {
                if (copy[l] != nums[end--]) {
                    System.out.println("no");
                    return;
                }
            }
            System.out.println("yes");
        }
    }
}
