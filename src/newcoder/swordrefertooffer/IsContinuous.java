package newcoder.swordrefertooffer;

import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-5
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length <= 0 || numbers == null) {
            return false;
        }
        // 对数组排序
        Arrays.sort(numbers);
        int countArrayZero = 0;
        int length = numbers.length;
        for (int i = 0; i < length && numbers[i] == 0; i++) {
            countArrayZero++;
        }

        int small = countArrayZero;
        int big = small + 1;
        int gap = 0;
        while (big < length) {
            // 扑克牌中出现了对子
            if (numbers[small] == numbers[big]) {
                return false;
            }
            gap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return gap > countArrayZero ? false : true;
    }
}
