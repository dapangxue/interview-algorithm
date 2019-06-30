package leetcode.chapter10;

/**
 * Created with IntelliJ IDEA.
 * LeetCode - 1017题
 * 参考链接：https://www.geeksforgeeks.org/convert-number-negative-base-representation/
 * https://en.wikipedia.org/wiki/Negative_base
 * https://blog.csdn.net/qq_17550379/article/details/88942131
 * @author WuXue
 * @date 2019/6/2 0002
 */
public class BaseNeg2 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (N != 0) {
            int remainder = N % -2;
            N = N / -2;
            if (remainder < 0) {
                remainder += 2;
                N = N + 1;
            }
            stringBuilder.append(remainder);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        BaseNeg2 b = new BaseNeg2();
        System.out.println(b.baseNeg2(12));
    }
}
