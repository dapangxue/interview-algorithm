package newcoder.swordrefertooffer;

import newcoder.baidu.first.Solution;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 18-12-29
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        // 说明：此方法不考虑StringBuilder里的replace方法
        int spaceNum = 0;
        // 1.统计空格的个数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        // 2.提前设置新的字符串的长度
        int newLength = str.length() + spaceNum * 2;
        int newIndex = newLength - 1;
        int oldIndex = str.length() - 1;
        str.setLength(newLength);
        for (; oldIndex >= 0 && oldIndex < newIndex; oldIndex--) {
            // 如果字符串中有空格
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        StringBuffer stringBuffer = new StringBuffer(" Hello    World ");
        System.out.println(replaceSpace.replaceSpace(stringBuffer));
    }
}
