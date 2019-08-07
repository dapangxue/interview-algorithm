package leetcode.chapter2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/27 0027
 */
public class CanFinish {

    /**
     * 对于拓扑排序来讲，如果构成循环，那么每个节点的入度都不为0
     */

    /**
     * 通过拓扑排序（拓扑排序只针对有向图）
     * @param numCourses
     * @param prerequisites （采用边缘列表表示）
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 如果没有课程需要选择
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return false;
        }

        // 构建一个入度数组
        int[] inDegree = new int[numCourses];
        for (int[] t : prerequisites) {
            inDegree[t[0]]++;
        }

        // 将入度为0的节点加入队列
        Queue<Integer> queue = new LinkedList<>();
        // 拓扑排序的结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0, length = inDegree.length; i < length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 队列中入度为0的点取出来
            Integer node = queue.poll();
            // 加入拓扑排序的集合
            result.add(node);
            for (int[] t : prerequisites) {
                if (t[1] == node) {
                    inDegree[t[0]]--;
                    if (inDegree[t[0]] == 0) {
                        queue.offer(t[0]);
                    }
                }
            }
        }
        // 拓扑排序的结果
        System.out.println(result);
        return result.size() == numCourses;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // 构造一个set数组，用于存储当前节点的前缀节点
        Set<Integer>[] sets = new Set[numCourses];
        for (int i = 0, length = sets.length; i < length; i++) {
            sets[i] = new HashSet<>();
        }

        for (int[] t : prerequisites) {
            sets[t[0]].add(t[1]);
        }

        int[] marked = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, marked, sets)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 采用dfs递归遍历
     * @param index
     * @param marked
     * @param sets
     * @return
     */
    public static boolean dfs(int index, int[] marked, Set[] sets) {
        if (marked[index] == 2) {
            return false;
        }

        // 表示当前节点正在遍历，如果当前节点正在遍历，再次遍历到当前节点，那么表示图有环
        if (marked[index] == 1) {
            return true;
        }
        // 执行到这说明当前节点没有被遍历过
        marked[index] = 1;
        Set<Integer> set = sets[index];
        for (Integer t : set) {
            if (dfs(t, marked, sets)) {
                return true;
            }
        }
        marked[index] = 2;
        return false;
    }

    public static void main(String[] args) {
        int numCources = 2;
        int[][] a = {{0, 1}, {1, 0}};
        System.out.println(canFinish1(numCources, a));
    }
}
