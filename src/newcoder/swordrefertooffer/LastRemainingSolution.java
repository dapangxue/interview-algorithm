package newcoder.swordrefertooffer;

import java.util.LinkedList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-5
 */
public class LastRemainingSolution {
    public int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int base = 0;
        while (list.size() != 1) {
            base = (base + m - 1) % list.size();
            list.remove(base);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    public int LastRemaining_Solution1(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % (i);
        }
        return last;
    }
}
