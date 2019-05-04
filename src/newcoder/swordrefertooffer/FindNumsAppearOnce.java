package newcoder.swordrefertooffer;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-31
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 判断输入数组的元素是否不足或者为空数组
        if (array.length < 2 || array == null) {
            return;
        }

        // 获取将数组分为两个数组的特殊数
        int resultExclusiveOr = 0;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            resultExclusiveOr ^= array[i];
        }
        int index = findFirstBit1(resultExclusiveOr);
        for (int j = 0; j < length; j++) {
            if (isBit1(array[j], index)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }
    }

    /**
     * 查找特殊数中bit的第一位是1需要的偏移量，从右向左
     *
     * @param num
     * @return
     */
    public int findFirstBit1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            indexBit++;
        }
        return indexBit;
    }

    public boolean isBit1(int data, int index) {
        data >>= index;
        return (data & 1) == 1;
    }
}
