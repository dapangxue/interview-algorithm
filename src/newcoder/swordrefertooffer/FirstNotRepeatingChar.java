package newcoder.swordrefertooffer;

import java.util.HashMap;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-15
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, length = str.length(); i < length; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.replace(c, ++count);
            }
        }
        for (int i = 0, length = str.length(); i < length; i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar firstNotRepeatingChar = new FirstNotRepeatingChar();
        System.out.println(firstNotRepeatingChar.FirstNotRepeatingChar("abaccdeff"));
    }
}
