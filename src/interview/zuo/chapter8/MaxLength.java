package interview.zuo.chapter8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/4/29 0029
 */
public class MaxLength {
    /**
     * 《左程云算法-面试指南》P358
     * 未排序数组中累加和小于或等于给定值的最长子数组长度
     * 在数组下标为j的子数组sum[0 ... j]中找到大于(sum - k)的做左边的索引比如i,那么j - i + 1就是当前子数组的最大长度
     * @param array
     * @return
     */
    public static int getMaxLength(int[] array, int k) {
        int length = array.length;
        // 定义一个辅助数组保存array数组从0~j之间和的最大值
        int[] helper = new int[length + 1];
        // 数组和临时和
        int temp = 0;
        for (int i = 1; i < length + 1; i++) {
            temp += array[i - 1];
            helper[i] = Math.max(helper[i - 1], temp);
        }
        // System.out.println(Arrays.toString(helper));
        int sum = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
            // 在helper辅助数组中找出大于sum - k的最小的索引，且这个索引要小于i
            int index = getLessIndex(helper, sum - k);
            // System.out.println(index);
            int len = index == -1 ? 0 : i - index + 1;
            result = Math.max(result, len);
        }
        return result;
    }

    /**
     * 《左程云算法-面试指南》p355
     * 未排序数组中累加和为给定值的最长子数组问题
     * 思路：遍历数组，采用键值对的数据结构，key保存sum值，value保存第一次出现sum值的下标
     * 1、在数组元素累加和sum大于k的前提下，(sum - k)若在Map中出现过，则对应的value就是最早出现这个sum的下标。当前下标减去value即为所得
     * 2、s(j)表示从0~j的和，(0~i),(i+1~j)中如果i+1到j的和满足要求k（s(j) - s(i) == k），j - i即为所求。
     * @param array
     * @param k
     * @return
     */
    public static int maxLength1(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, -1);
        for (int i = 0, length = array.length; i < length; i++) {
            sum += array[i];
            // 存储sum对应最早的下标
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            int temp = sum - k;
            if (temp >= 0 && map.containsKey(temp)) {
                result = Math.max(result, i - map.get(temp));
            }
        }
        return result;
    }

    /**
     * 找到数组a中大于k的最小的下标
     * @param a
     * @param k
     * @return
     */
    public static int getLessIndex(int[] a, int k) {
        int left = 0, right = a.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] >= k) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 3, 3};
        System.out.println(maxLength1(array, 18));
    }
}
