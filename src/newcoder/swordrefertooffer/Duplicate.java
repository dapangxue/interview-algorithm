package newcoder.swordrefertooffer;

import java.util.HashSet;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-7
 */
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int [] duplication) {
        if (length <= 0 || numbers == null)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.contains(numbers[i])) {
                set.add(numbers[i]);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        System.out.println(duplicate.duplicate(new int[]{}, 4, new int[1]));
    }
}
