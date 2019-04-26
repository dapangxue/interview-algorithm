package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-9
 */
public class GetLeastNumbersSolution {

    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input.length < k) {
            return arrayList;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    // 采用快速排序的思想
    public ArrayList<Integer> GetLeastNumbers() {
        return null;
    }

    private int partition(int[] a, int low, int high) {
        // 定义一个基准值
        int value = a[low];

        while (low < high) {
            while (low < high && a[high] >= value) {
                high--;
            }
            swap(a, low, high);
            while (low < high && a[low] <= value) {
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }

    /**
     * 交换数组中的两个元素
     * @param a
     * @param i
     * @param j
     */
    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        GetLeastNumbersSolution getLeastNumbersSolution = new GetLeastNumbersSolution();
        int[] a = new int[]{3, 2, 2, 3, 3, 3, 4, 1};
        System.out.println(getLeastNumbersSolution.partition(a, 0, a.length-1));
    }

}
