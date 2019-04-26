package newcoder.swordrefertooffer;

import java.util.ArrayList;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-1
 */
public class FindContinuousSequence {
    public static boolean find(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return false;
        }

        int headIndex = 0;
        int tailIndex = array.length-1;

        while (headIndex < tailIndex) {
            int fix = 0;
            if ((fix = array[headIndex] + array[tailIndex]) == sum) {
                return true;
            } else if (fix < sum) {
                headIndex++;
            } else {
                tailIndex--;
            }
        }
        return false;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) {
            return list;
        }

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                list.add(helper(small, big));
            }
            while (curSum > sum) {
                curSum -= small;
                small++;

                if (curSum == sum && small < middle) {
                    list.add(helper(small, big));
                }
            }
            big++;
            curSum += big;
        }
        return list;
    }

    private static ArrayList<Integer> helper(int small, int big) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(find(array, 20));
        System.out.println(FindContinuousSequence(15));
    }
}
