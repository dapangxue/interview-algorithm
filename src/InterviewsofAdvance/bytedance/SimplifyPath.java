package InterviewsofAdvance.bytedance;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i ++) {
            if (s[i] == null || s[i].length() != 0) {
                if (s[i].equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if(s[i].equals(".")){
                    continue;
                } else {
                    stack.push(s[i]);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
            stringBuilder.insert(0, "/");
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "/home//foo/";
        String[] c;
        System.out.println(Arrays.toString(c = a.split("/")));
        System.out.println(c[0].length());
        System.out.println(simplifyPath(a));
    }
}
