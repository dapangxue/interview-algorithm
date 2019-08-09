package leetcode.chapter1;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/8/9 0009
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[length];

        if (length == 0) {
            return result;
        }

        generatePermute(nums, used, result, new Stack<>(), 0);

        return result;
    }

    public void generatePermute(int[] nums,
                                int[] used,
                                List<List<Integer>> result,
                                Stack<Integer> path,
                                int size) {
        if (size == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            // 如果没有被使用
            if (used[i] == 0) {
                path.push(nums[i]);
                used[i] = 1;
                generatePermute(nums, used, result, path, size + 1);
                path.pop();
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
}
