package newcoder.swordrefertooffer;

import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-2
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return helper(sequence, sequence.length-1);
    }

    /**
     *
     * @param sequence
     * @param end 数组最后一位的索引
     * @return
     */
    private boolean helper(int[] sequence, int end) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        // 获取根节点的值
        int root = sequence[end];
        // System.out.println("root" + root + "array length = " + sequence.length);
        // 根据二叉搜索树的特性，先遍历左子树，后遍历右子树，最后遍历根节点
        int i = 0;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // System.out.println("i = " + i);
        boolean left = true;
        if (i > 0) {
            left = helper(Arrays.copyOf(sequence, i), i-1);
        }
        boolean right = true;
        if (i < sequence.length-1) {
            right = helper(Arrays.copyOfRange(sequence, i, sequence.length-1), sequence.length-i-2);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,6,9,11,10,8};
        int[] b = new int[]{7,4,6,5};
        int[] c = new int[3];
        System.out.println(c.length);
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(c));
    }
}
