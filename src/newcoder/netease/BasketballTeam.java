package newcoder.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/3 0003
 */
public class BasketballTeam {

    private static int count = 0;

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7};
        List<Integer> s = Arrays.stream(a).boxed().collect(Collectors.toList());
        dfs(new ArrayList<>(), new ArrayList<>(), s, s.size());
        System.out.println(count);
    }

    /**
     * 计算能力值的组队方法
     * @param a 篮球运动员的能力
     * @return
     */
    public static void dfs(List<Integer> a, List<Integer> b, List<Integer> s, int size) {
        if (a.size() + b.size() == size) {
            Collections.sort(a);
            Collections.sort(b);

            System.out.print(a);
            System.out.print(b);

            int sumA = a.stream().mapToInt((t) -> t).sum();
            int sumB = b.stream().mapToInt((t) -> t).sum();

            System.out.println("sumA = " + sumA + " sumB = " + sumB);
            if (sumA > sumB && sumA - sumB < 2 * a.get(0)) {
                count++;
            }
        }

        if (!s.isEmpty()) {
            int m = s.get(s.size() - 1);
            a.add(m);
            s.remove(s.size() - 1);
            dfs(a, b, s, size);
            int index = a.indexOf(m);
            a.remove(index);
            b.add(m);
            dfs(a, b, s, size);
        }
    }
}
