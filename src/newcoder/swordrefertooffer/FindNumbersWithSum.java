package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-2
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array.length < 2 || array == null) {
            return arrayList;
        }

        // 标定起始的数组索引
        int head = 0, tail = array.length - 1;
        while (head < tail) {
            int curSum = 0;
            if ((curSum = array[head] + array[tail]) == sum) {
                arrayList.add(array[head]);
                arrayList.add(array[tail]);
                break;
            } else if (curSum < sum) {
                head ++;
            } else {
                tail --;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
        System.out.println(findNumbersWithSum.FindNumbersWithSum(new int[]{1, 2, 3, 4, 5}, 6));
    }
}
