/**
 * Created with IntelliJ IDEA.
 * 字节跳动面试算法题目
 * @author WuXue
 * @date 2019/7/17 0017
 */
public class MatchArray {
    /*
    算法描述：
    给定一个二维数组{1, 2, 3, 4, 5, 6}
                   {1, 2, 3, 6, 7, 9}
                   {2, 5, 8, 9, 1, 2}
                   {2, 5, 6, 4, 5, 3}
                   {6, 7, 8, 9, 1, 2}
    给定一个target：一位数组{1, 2, 3},找出这个一维所在的二维数组中的位置
    提示1：数组的数字都是0~9的
     */

    /**
     * 暴力解法，时间复杂度为O(M*N*K)
     */
    public static void matchArray() {
        int[][] a = {{1, 2, 3, 1, 2, 3}, {1, 2, 4, 4, 5, 6}};
        int[] t = {1, 2, 3};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == t[0]) {
                    int k = 1;
                    for (k = 1; k < t.length; k++) {
                        if (a[i][j + k] != t[k]) {
                            break;
                        }
                    }
                    if (k == t.length) {
                        System.out.println("i = " + i + " j = " + j);
                    }
                }
            }
        }
    }

    /**
     * 时间复杂度为O(MN)
     * @param a
     * @param target
     */
    public static void matchArray1(int[][] a, int[] target) {
        // 数组中的数字都是0~9的，那么不会存在{12， 9}和{1， 2， 9}匹配的这种情况
        // 将target转换成一个整数
        int t = target[0];
        for (int i = 1, length = target.length; i < length; i++) {
            t *= 10;
            t += target[i];
        }

        for (int i = 0; i < a.length; i++) {
            int k = a[i][0];
            int count = 1;
            int j = 0;
            while (j < a[0].length) {
                // 首先凑够和target一样长的值，利用滑动窗口
                if (count < target.length) {
                    ++j;
                    k *= 10;
                    k += a[i][j];
                    count++;
                }

                if (count == target.length) {
                    System.out.println(k);
                    // 在值的长度和target数组长度一样后，查看两者的值是否一样
                    if (k == t) {
                        System.out.println("i = " + i + " j = " + (j - count + 1));
                    }

                    // 生成除数去除整数的首位
                    int divisor = 1;
                    for (int m = 2; m <= count; m++) {
                        divisor *= 10;
                    }
                    if (j == a[0].length - 1) {
                        break;
                    }
                    k = (k % divisor) * 10 + a[i][++j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 1, 2, 3}, {1, 2, 4, 4, 5, 6}};
        int[] t = {1};
        matchArray1(a, t);
    }

}
