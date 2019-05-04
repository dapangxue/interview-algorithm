package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-15
 */
public class GetUglyNumberSolution {
    public int GetUglyNumber_Solution(int index) {
        int uglyNumber = 1;
        for (int i = 2; i <= index; i++) {
            uglyNumber++;
            while (!isUgly(uglyNumber)) {
                uglyNumber++;
            }
        }
        return uglyNumber;
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1 ? true : false;
    }

    public static void main(String[] args) {
        GetUglyNumberSolution getUglyNumberSolution = new GetUglyNumberSolution();
        System.out.println(getUglyNumberSolution.GetUglyNumber_Solution1(9));
    }

    public int GetUglyNumber_Solution1(int index) {
        if (index < 7) {
            return index;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; i++) {
            list.add(Math.min(Math.min(list.get(index2)*2, list.get(index3)*3), list.get(index5)*5));
            if (list.get(list.size()-1) == list.get(index2)*2) {
                index2++;
            }
            if (list.get(list.size()-1) == list.get(index3)*3) {
                index3++;
            }
            if (list.get(list.size()-1) == list.get(index5)*5) {
                index5++;
            }
        }
        return list.get(list.size()-1);
    }

}
