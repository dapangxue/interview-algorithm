package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 * 数字在排序数组中出现的次数
 * 题目描述：统计一个数字在排序数组中出现的次数。
 *
 * @author wuxue
 * @date 19-1-7
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {
            return 0;
        }
        int leftIndex = -1, rightIndex = -1;
        int left = 0, right = array.length-1;

        // 1.首先查找对应数字范围左边索引
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                leftIndex = mid;
                right = mid - 1;
            }
        }
        System.out.println(leftIndex);
        left = 0;
        right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                left = mid + 1;
                rightIndex = mid;
            }
        }
        if (rightIndex == -1 && leftIndex == -1) {
            return 0;
        }
        return rightIndex - leftIndex + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,3,3,3,4,5};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.GetNumberOfK(a, 2));
    }
}
