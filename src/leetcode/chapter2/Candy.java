package leetcode.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * leetcode 
 * @author WuXue
 * @date 2019/8/1 0001
 */
public class Candy {
    /**
     * version1
     * @param ratings
     * @return
     */
    public int candy1(int[] ratings) {
        // int[] ratings = {1, 2, 3, 5, 6, 1};
        // 分发的糖果分别为1, 2, 3, 4, 5, 6, 1
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);

        // 用于表示当前的糖果有没有修改过，修改过为true，没有修改过为false
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0, length = ratings.length; i < length; i++) {
                // 首先当前索引前一位进行比较
                if (i > 0 && ratings[i] > ratings[i - 1] && result[i] <= result[i - 1]) {
                    result[i] = result[i - 1] + 1;
                    flag = true;
                }
                if (i < length - 1 && ratings[i] > ratings[i + 1] && result[i] <= result[i + 1]) {
                    result[i] = result[i + 1] + 1;
                    flag = true;
                }
            }
        }
        return Arrays.stream(result).sum();
    }

    /**
     * version2
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];

        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        int[] result = new int[ratings.length];

        for (int i = 1, length = ratings.length; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }
        for (int i = 0, length = ratings.length; i < length; i++) {
            result[i] = Math.max(leftToRight[i], rightToLeft[i]);
        }
        return Arrays.stream(result).sum();
    }

    /**
     * version4 (时间复杂度O（N），空间复杂度O（1）)的算法，暂时没想明白
     * @param ratings
     * @return
     */
    public int candy4(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int oldSlope = 0;
        int up = 0;
        int down = 0;
        for (int i = 1, length = ratings.length; i < length; i++) {
            int newSlope = ratings[i] > ratings[i - 1] ? 1 : ratings[i] < ratings[i - 1] ? -1 : 0;
            if (oldSlope > 0 && newSlope == 0 || oldSlope < 0 && newSlope >= 0) {

            }
            if (newSlope > 0) {
                up++;
            }
            if (newSlope < 0) {
                down++;
            }
        }
        return 0;
    }

    public int count(int n) {
        return n * (n + 1) / 2;
    }
}
