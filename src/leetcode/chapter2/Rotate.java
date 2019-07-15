package leetcode.chapter2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/14 0014
 */
public class Rotate {

    public static int[]  rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i ++, j --) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(rotate(a, 13)));
    }

}
