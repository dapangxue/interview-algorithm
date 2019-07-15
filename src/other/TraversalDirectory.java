package other;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/30 0030
 */
public class TraversalDirectory {
    public static Map<String, Integer> result = new HashMap<>();

    public static void traversalFile(String path) {
        File file = new File(path);

        if (!file.exists()) {
            return;
        }

        File[] files = file.listFiles();
        // 遍历整个目录
        for (File x : files) {
            if (!x.isHidden()) {
                if (x.isFile()) {
                    String suffix = x.getName().substring(x.getName().lastIndexOf('.') + 1);
                    result.put(suffix, result.getOrDefault(suffix, 1) + 1);
                } else if (x.isDirectory()) {
                    String absolutePath = x.getAbsolutePath();
                    traversalFile(absolutePath);
                }
            }
        }
    }

    public static void main(String[] args) {
        traversalFile("E:/CloudMusic/");
        System.out.println(result);


    }
}
