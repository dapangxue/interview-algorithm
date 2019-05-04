package newcoder.swordrefertooffer;

import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-8
 */
public class MoreThanHalfNumSolution {
    public int MoreThanHalfNum_Solution(int [] array) {
        // 首先将数组排序
        Arrays.sort(array);

        // 题目提示数字出现的次数超过数组长度的一半
        int length = array.length;
        int value = array[length-1/2];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                count++;
            }
        }

        if (count > length/2) {
            return value;
        } else {
            return 0;
        }
    }

    /**
     * 采用快速排序思想
     * @param array
     * @return
     */
    public int MoreThanHalfNum(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int start = 0;
        int length = array.length;
        int end = length-1;
        int middle = (length-1)>>1;

        // 返回首次快速排序的索引
        int index = partition(array, start, end);
        while (index != middle) {
            if (index < middle) {
                index = partition(array, index+1, end);
                // System.out.println(index);
            } else {
                index = partition(array, start, index-1);
                // System.out.println(index);
            }
        }
        int result = array[index];

        // 统计result出现的次数
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == result) {
                count ++;
            }
        }
        if (count*2 > length) {
            return result;
        } else {
            return 0;
        }
    }


    private int partition(int[] array, int low, int high) {
        // 找到一个基准值
        int value = array[low];

        while (low < high) {
            while (low < high && array[high] >= value) {
                high--;
            }
            swap(array, low, high);
            while (low < high && array[low] <= value) {
                low++;
            }
            swap(array, low, high);
        }
        return low;
    }
    /**
     * 交换一个数组中两个索引对应的数字
     * @param array
     * @param num1
     * @param num2
     */
    public void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    public static void main(String[] args) {
        MoreThanHalfNumSolution moreThanHalfNumSolution = new MoreThanHalfNumSolution();
        int[] a = new int[]{2, 3, 3, 3, 3, 5, 1, 1, 6, 3, 7, 7,7,7,7,7,7,7,7,7,7,7,7,7,7,77,7,77,7,7, 3, 3, 3, 3};
        int[] b = new int[]{4, 1, 5, 3, 3, 3, 3};
        int[] c = new int[]{1, 2, 3, 3, 3, 3, 3, 3, 4};
        // System.out.println(moreThanHalfNumSolution.partition(c, 2, c.length-1));
        System.out.println(moreThanHalfNumSolution.MoreThanHalfNum(a));
    }
}
