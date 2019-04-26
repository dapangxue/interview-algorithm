package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-13
 */
public class FindGreatestSumOfSubArray {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length <= 0) {
            return 0;
        }

        int maxSubSum = Integer.MIN_VALUE;
        // 子序列之和
        int subSum = Integer.MIN_VALUE;
        // int[] max = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (subSum <= 0) {
                subSum = array[i];
            } else {
                subSum += array[i];
            }
            if (subSum > maxSubSum) {
                maxSubSum = subSum;
            }
        }
        return maxSubSum;
    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        if (array.length <= 0) {
            return 0;
        }

        int maxSubSum = Integer.MIN_VALUE;
        int[] max = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || i > 0 && max[i-1] <= 0) {
                max[i] = array[i];
            } else {
                max[i] = max[i-1] + array[i];
            }

            if (max[i] > maxSubSum) {
                maxSubSum = max[i];
            }
        }
        return maxSubSum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray1(a));
    }

}
