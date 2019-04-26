package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-13
 */
public class NumberOf1Between1AndNSolution {

    public static int numberOf1Between1AndNSolution(int n) {
        if (n <= 0) {
            return 0;
        }
        // 首先计算输入数字n的长度
        int len = helper(n);

        int temp = (int)Math.pow(10, len-1);
        // 数字n的首位数字
        int first = n / temp;
        // 核心算法，要统计数字n中1的个数，可以先统计第一位和后几位
        int firstOneNum = first == 1 ? n % temp + 1 : temp;
        int otherOneNum = first * (len-1) * (temp/10);
        return firstOneNum + otherOneNum + numberOf1Between1AndNSolution(n%temp);
    }

    private static int helper(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndNSolution(1));
    }
}
