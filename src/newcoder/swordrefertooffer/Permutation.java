package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-6
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str.length() == 0 || str.isEmpty()) {
            return arrayList;
        }
        char[] array = str.toCharArray();
        helper(array, 0, arrayList);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        return arrayList;
    }

    private void helper(char[] array, int num, ArrayList<String> arrayList) {
        if (num == array.length-1) {
            String value = String.valueOf(array);
            if (!arrayList.contains(value)) {
                arrayList.add(value);
            }
        }
        for (int i = num; i < array.length; i++) {
            swap(array, num, i);
            helper(array, num+1, arrayList);
            swap(array, num, i);
        }
    }

    private void swap(char[] array, int i, int j) {
        if (i == j) {
            return;
        }

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.Permutation("abcd");
    }
}
