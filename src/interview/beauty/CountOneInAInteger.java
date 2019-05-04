package interview.beauty;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/4/28 0028
 */
public class CountOneInAInteger {

    /**
     * 统计一个整数n中，从1到n的个数
     * @param n
     * @return
     */
    public static int countOneInAInteger(int n) {
        /*
        假设有个数字203，对于十位来讲，受高位的影响，它的1的个数有10~19、110~119
        假设有个数字213，对于十位来讲，受高位的影响，它的1的个数有10~19、110~119，即2*10。受个位的影响，1的个数为个位数+1.
        假设有个数组223，对于十位来讲，受高位的影响，它的1的个数有10~19、110~119、210~219，即21*10。
         */
        // current表示当前位的数字，比如12345，第三位是3，第4位是4
        int result = 0;
        int factor = 1;
        int low = 0, current = 0, high = 0;

        while (n / factor != 0) {
            low = n - (n / factor) * factor;
            high = n / (factor * 10);
            current = (n / factor) % 10;

            switch (current) {
                case 0:
                    result += high * factor;
                    break;
                case 1:
                    result += high * factor + (low + 1);
                    break;
                default:
                    result += (high + 1) * factor;
                    break;
            }
            factor *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countOneInAInteger(123));
    }

}
