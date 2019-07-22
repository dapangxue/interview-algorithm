package interview.sort;

import org.omg.CORBA.ARG_IN;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/16 0016
 */
public class HeapSort {

    /*
    堆排序的流程：
    1、首先构建堆,这一步可以将数组看成堆，也就是说只要给出数组，表示已经建立完堆
    2、建立最小堆，不断地将最小堆的根节点和数组待排序的最后一个节点替换
    3、整理替换后的节点
     */

    public static void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        // 建立一个小根堆
        buildArrayToHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            buildMinHeap(array, i - 1, 0);
        }
    }

    /**
     * 构建一个小根堆
     * @param array
     */
    public static void buildArrayToHeap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int mid = array.length / 2;
        for (int i = mid; i >= 0; i--) {
            buildMinHeap(array, array.length - 1, i);
        }
    }

    /**
     * 建立最小堆
     * @param array
     * @param index
     */
    public static void buildMinHeap(int[] array, int size, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int minIndex = index;
        if (leftIndex <= size && array[leftIndex] < array[minIndex]) {
            minIndex = leftIndex;
        }
        if (rightIndex <= size && array[rightIndex] < array[minIndex]) {
            minIndex = rightIndex;
        }

        if (minIndex != index) {
            swap(array, minIndex, index);
            buildMinHeap(array, size, minIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56};
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

}
