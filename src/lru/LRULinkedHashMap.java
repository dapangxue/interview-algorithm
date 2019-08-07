package lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/23 0023
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    /**
     * 初始内存容量
     */
    private int capacity;

    LRULinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){
        //，每加入一个元素，就判断是size是否超过了已定的容量
        System.out.println("此时的size大小="+size());
        if((size() > capacity)) {
            System.out.println("超出已定的内存容量，把链表顶端元素移除：" + eldest.getValue());
        }
        return size() > capacity;
    }

    public static void main(String[] args) throws Exception{

        Map<Integer,Integer> map=new LRULinkedHashMap<Integer, Integer>(4);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        System.out.println(map);
        map.get(1);
        System.out.println(map);
        map.put(5, 5);
        System.out.println(map);

    }
}
