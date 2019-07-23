package SwordRefertoOffer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 思路：本体的最优解法就是时间复杂度为O（n）,空间复杂度为O（1）
 * 采用Map,虽然可以达到时间复杂度O(n),但是空间复杂度会高点
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class Duplicate {
    public static boolean duplicate(int numbers[], int length, int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i = 0; i < length; i ++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            // 如果数组的下标和数组的值不等
            while (numbers[i] != i) {
                // 判断下标对应的值是否和值作为下标对应的值相等，也就是判断是否数组内有数字重复
                // 如果不相等，那么就调整顺序，直到相等，或者判断到数据重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = i;
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(duplicate(new int[]{2,3,1,0,2,5,3})));

    }

    /*
    此题目可以解决掉字节跳动的面试题：
    数组中重复的数字，改版数字大小为0-n，数组长度为n
     */
    public static int[] duplicate(int[] numbers) {
        int[] flag = new int[1];
        while (duplicate(numbers, numbers.length, flag)) {
            numbers[flag[0]] = flag[0];
        }
        return numbers;
    }
}
