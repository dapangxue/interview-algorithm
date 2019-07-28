package leetcode.contest;

/**
 * Created with IntelliJ IDEA.
 * leetcode 第147场周赛字母板上的路径
 * @author WuXue
 * @date 2019/7/28 0028
 */
public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        String[]  str = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        // 存放结果
        StringBuilder result = new StringBuilder();
        int[] location = new int[2];
        for (int i = 0; i < target.length(); i++) {
            char fix = target.charAt(i);
            // 从index位置开始找到fix的位置
            String coordinate = findFix(str, fix, location[0] * 5 + location[1], location);
            result.append(coordinate);
        }
        return result.toString();
    }

    public String findFix(String[] str, char fix, int index, int[] location) {
        int fixToCoordinate = fix - 'a';
        if (fixToCoordinate == index) {
            return "!";
        }

        int x = fixToCoordinate / 5;
        int y = fixToCoordinate % 5;
        location[0] = x;
        location[1] = y;
        StringBuilder r = new StringBuilder();
        int currentX = index / 5;
        int currentY = index % 5;
        int xMoveNum = Math.abs(x - currentX);
        int yMoveNum = Math.abs(y - currentY);
        if (yMoveNum != 0) {
            while (y < currentY) {
                r.append("L");
                currentY--;
            }
            while (y > currentY) {
                r.append("R");
                currentY++;
            }
        }
        if (xMoveNum != 0) {
            while (x < currentX) {
                r.append("U");
                currentX--;
            }
            while (x > currentX) {
                r.append("D");
                currentX++;
            }
        }

        return r.append("!").toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath a = new AlphabetBoardPath();
        System.out.println(a.alphabetBoardPath("code"));
    }
}
