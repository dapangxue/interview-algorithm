package interview.zuo.other;

/**
 * Created with IntelliJ IDEA.
 * Manancher算法主要用于解决回文子串的问题,比如求取最长的回文子串
 * @author WuXue
 * @date 2019/7/12 0012
 */
public class Manacher {

    /**
     * 回文子串处理时涉及到奇回文和偶回文，所以统一将它们处理为奇回文
     * @param s
     * @return
     */
    public static String manacherPreTreatment(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length() * 2 + 1);
        for (int i = 0, length = s.length(); i < length; i++) {
            stringBuilder.append('#');
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append('#');
        return stringBuilder.toString();
    }

    /**
     * 求取字符串的最长回文子串
     * @param s
     * @return
     */
    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 当前的回文中心
        int c = -1;
        // 回文中心对应的最优边界
        int r = -1;
        String preTreatmentStr = manacherPreTreatment(s);
        // 预处理后每个字符串对应的回文子串的半径
        int[] pArr = new int[preTreatmentStr.length()];
        int max = Integer.MIN_VALUE;

        for (int i = 0, length = preTreatmentStr.length(); i < length; i++) {
            pArr[i] = i < r ? Math.min(pArr[2 * c - i], r - i) : 0;
            while (i - pArr[i] - 1 >= 0 && i + pArr[i] + 1 <= length - 1) {
                if (preTreatmentStr.charAt(i - pArr[i] - 1) == preTreatmentStr.charAt(i + pArr[i] + 1)) {
                    pArr[i] ++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > r) {
                r = i + pArr[i];
                c = i;
            }
            max = Math.max(pArr[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(manacher("abacbccbcaba"));
    }

}
