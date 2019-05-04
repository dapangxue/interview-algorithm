package newcoder.swordrefertooffer;

import java.util.*;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-14
 */
public class PrintMinNumber {
    public static String PrintMinNumber(int[] numbers) {
        if (numbers.length <= 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        // 将数组转为list
        for (int x : numbers) {
            list.add(x);
        }

        // 将集合排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1) + String.valueOf(o2);
                String b = String.valueOf(o2) + String.valueOf(o1);
                return a.compareTo(b);
            }
        });
        for (Integer x : list) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
    }
}
