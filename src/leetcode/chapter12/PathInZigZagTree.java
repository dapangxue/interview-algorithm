package leetcode.chapter12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/30 0030
 */
public class PathInZigZagTree {
    public static List<Integer> pathInZigZagTree(int label) {
        // 查看当前标签在树的第几层上,从0开始
        int c  = (int) (Math.log((double) label) / Math.log(2.0));
        // 判断当前行是正常的行还是不正常的行，如果行是偶数行就是正常的行，如果是奇数行，那么就是不正常的行
        boolean normal = (c & 1) == 1 ? false : true;
        List<Integer> result = new ArrayList<>();
        while (label > 0) {
            result.add(0, label);
            label /= 2;
        }
        // 对于偶数行只要改变奇数行即可，对于奇数行只要改变偶数行即可
        if (normal) {
            for (int i = 1, size = result.size(); i < size - 1; i += 2) {
                int left = (int) Math.pow(2, i);
                int right = (int) Math.pow(2, i + 1) - 1;
                result.set(i, right - (result.get(i) - left));
            }
        } else {
            for (int i = 2, size = result.size(); i < size - 1; i+= 2) {
                int left = (int) Math.pow(2, i);
                int right = (int) Math.pow(2, i + 1) - 1;
                result.set(i, right - (result.get(i) - left));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(26));
    }
}
