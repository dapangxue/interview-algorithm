package newcoder.swordrefertooffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-10
 */
public class GetMedian {

    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if ((list.size() & 1) == 0) {
            int c = list.size()/2;
            return (double) (list.get(c) + list.get(c-1))/2;
        } else {
            int mid = (list.size()-1)/2;
            return (double) list.get(mid);
        }
    }

}
