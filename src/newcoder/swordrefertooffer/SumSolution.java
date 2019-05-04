package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-7
 */
public class SumSolution {
    public class Solution {
        public int Sum_Solution(int n) {
            int sum = n;
            boolean t = (n > 0) && ((sum += Sum_Solution(--n)) > 0);
            return sum;
        }
    }
}
