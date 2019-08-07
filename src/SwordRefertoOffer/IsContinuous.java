package SwordRefertoOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/24 0024
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        int count = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            }
        }

        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }

            count -= numbers[i + 1] - numbers[i] - 1;
        }
        return count >= 0;
    }
}
