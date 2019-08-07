package SwordRefertoOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/24 0024
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 0? list.get(0) : -1;
    }
}
