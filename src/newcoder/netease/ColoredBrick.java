package newcoder.netease;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-16
 */
public class ColoredBrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取彩色砖块
        String brick = scanner.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, length = brick.length(); i < length; i++) {
            char c = brick.charAt(i);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                int count = hashMap.get(c);
                hashMap.replace(c, ++count);
            }
        }

        if (hashMap.size() >= 3) {
            System.out.println(0);
        } else {
            System.out.println(hashMap.size());
        }
    }

}
