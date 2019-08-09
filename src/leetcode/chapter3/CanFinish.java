package leetcode.chapter3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * leetcode 210题，相当于求拓扑排序
 * @author WuXue
 * @date 2019/8/8 0008
 */
public class CanFinish {
    /**
     *
     * @param numCourses 多少门课程
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        if (numCourses == 0) {
            return result;
        }

        // 用于存储入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        // 统计每门课程出现了几次
        int[] countCourses = new int[numCourses];

        for (int[] t : prerequisites) {
            countCourses[t[0]]++;
        }

        for (int i = 0; i < numCourses; i ++) {
            if (countCourses[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int courseNum = queue.poll();
            result[index++] = courseNum;
            for (int[] t : prerequisites) {
                if (t[1] == courseNum) {
                    countCourses[t[0]]--;
                    if (countCourses[t[0]] == 0) {
                        queue.offer(t[0]);
                    }
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }

    /**
     * version2 这种方法只能判断有向图有没有环，但是无法求出拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }

        Set<Integer>[] sets = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            sets[i] = new HashSet<>();
        }

        for (int[] t : prerequisites) {
            sets[t[1]].add(t[0]);
        }

        int[] marked = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(marked, sets, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int[] marked, Set[] sets, int index) {
        // 表示正在被遍历
        if (marked[index] == 1) {
            return true;
        }

        if (marked[index] == 2) {
            return false;
        }

        marked[index] = 1;
        Set<Integer> nodes = sets[index];
        for (Integer x : nodes) {
            if (dfs(marked, sets, ++index)) {
                return true;
            }
        }
        marked[index] = 2;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
    }
}
