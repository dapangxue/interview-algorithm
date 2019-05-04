package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-8
 */
public class FirstAppearingOnce {

    List<Character> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char c : list) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
