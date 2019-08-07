package SwordRefertoOffer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/19 0019
 */
public class MovingCount {

    private int result = 0;

    public int movingCount(int threshold, int rows, int cols) {
        // 建立一个二维数组
        int[][] range = new int[rows][cols];
        helper(range, 0, 0, threshold);
        return result;
    }

    public void helper(int[][] range, int x, int y, int threshold) {
        if (x < 0 || x >= range.length || y < 0 || y >= range[0].length || !isRange(x, y, threshold) || range[x][y] == 1) {
            return;
        }
        result++;
        range[x][y] = 1;
        helper(range,x + 1, y, threshold);
        helper(range, x - 1, y, threshold);
        helper(range, x, y + 1, threshold);
        helper(range, x, y - 1, threshold);
    }

    public boolean isRange(int x, int y, int threshold) {
        int count = 0;
        while (x != 0) {
            count += x % 10;
            x /= 10;
        }
        while (y != 0) {
            count += y % 10;
            y /= 10;
        }
        return count <= threshold;
    }

    public static void main(String[] args) {
        MovingCount a = new MovingCount();
        int[][] range = new int[5][5];
        // System.out.println(a.isRange(15, 15, 11));
        System.out.println(a.movingCount(4, 5, 5));
    }

}
