package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/19 0019
 */
public class HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] fix = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean result = helper(matrix, fix, rows, cols, i, j, str, 0);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean helper(char[] matrix, boolean[] fix, int rows, int cols, int x, int y, char[] str, int index) {
        // 将二维坐标转化为一维坐标
        int i = x * cols + y;
        if (x < 0 || x >= rows || y < 0 || y >= cols || fix[i] == true || index > str.length || matrix[i] != str[index]) {
            return false;
        }
        fix[i] = true;
        index++;
        if (index == str.length) {
            return true;
        }
        boolean t =  helper(matrix, fix, rows, cols, x + 1, y, str, index) ||
                helper(matrix, fix, rows, cols, x - 1, y, str, index) ||
                helper(matrix, fix, rows, cols, x, y + 1, str, index) ||
                helper(matrix, fix, rows, cols, x, y - 1, str, index);
        if (t) {
            return true;
        } else {
            fix[i] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        System.out.println(hasPath(matrix, 5, 8, str));
    }

}
