package leetcode.chapter11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/23 0023
 */
public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 先比较出发点坐标
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else if (o1[2] != o2[2]) {
                    // 比较结束点坐标
                    return o1[2] - o2[2];
                } else {
                    // 最后比较乘客数量
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 1; i < trips.length; i++) {
            if (trips[i][1] < trips[i - 1][2]) {
                if (trips[i][0] + trips[i - 1][0] > capacity) {
                    return false;
                } else {

                }
            }
        }

        System.out.println(Arrays.deepToString(trips));
        return false;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        System.out.println(carPooling(trips, 4));
    }
}
