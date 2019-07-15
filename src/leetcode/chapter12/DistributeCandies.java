package leetcode.chapter12;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/6/30 0030
 */
public class DistributeCandies {

    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0;
        // 统计发到了第几轮糖果，从第0轮开始
        int c = 0;
        while (candies > 0) {
            // 统计当前小孩需要发的糖果数目
            int num = c * num_people + (index + 1);
            if (candies < num) {
                num = candies;
            }
            result[index] += num;
            candies -= num;
            if (++index == num_people) {
                c++;
                index = 0;
            }
            //index = nextPeople(index, num_people);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(19, 3)));
    }
}
