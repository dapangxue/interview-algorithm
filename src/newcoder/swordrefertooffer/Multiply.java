package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-7
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] b = new int[length];

        // 因为b数组同样也有length个元素，需要计算每个元素的值,复杂度O(n)
        for (int i = 0; i < length; i++) {
            int result = 1;
            for (int j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }
                result *= A[j];
            }
            b[i] = result;
        }
        return b;
    }

    // 比较好的方法
    public int[] multiply1(int[] A) {
        int length = A.length;
        int[] b = new int[length];

        b[0] = 1;
        for (int i = 1; i < length; i++) {
            b[i] = b[i-1] * A[i-1];
        }

        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {
            temp *= A[j+1];
            b[j] *= temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply1(new int[]{1,2,3,4,5});
    }
}
