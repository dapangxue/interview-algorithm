package interview.beauty;

/**
 * Create by IDEA
 * 《数学之美》中数字之魅-不要被阶乘吓倒
 * @author wuxue
 * @date 19-4-26
 */
public class Factorial {

    /**
     * 计算n的阶乘的末尾有几个0
     * @param n
     * @return
     */
    public static int getTailZeroNumber(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j % 5 == 0) {
                num ++;
                j /= 5;
            }
        }
        return num;
    }

    public static int getTailZeroNumber2(int n) {
        int num = 0;
        while (n != 0) {
            num += n / 5;
            n = n / 5;
        }
        return num;
    }

    /**
     * 可以理解为将n!表示为二进制的形式，如果二进制位第一个1出现的位置之后有0，
     * 其实是统计了含有质因数2的个数，然后再加1就能得到最低位1的位置（具体参看数学之美p127）
     * @param n
     * @return
     */
    public static int getLowestOne(int n) {
        int num = 0;
        while (n != 0) {
            n >>= 1;
            num += n;
        }
        return num + 1;
    }

    public static void main(String[] args) {
        System.out.println(getTailZeroNumber(55));
        System.out.println(getTailZeroNumber2(55));
        System.out.println(getLowestOne(5));
    }

}
