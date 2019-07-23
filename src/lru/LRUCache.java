package lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * LRU缓存中，使用Map来保存键值对（数据），双向链表来保证顺序
 * @author WuXue
 * @date 2019/7/17 0017
 */
public class LRUCache<K, V> {

    class CacheNode {
        CacheNode pre;
        CacheNode next;
        K key;
        V value;
    }

    /**
     * 用于存储缓存的节点
     */
    private Map<K, CacheNode> map;
    /**
     * 当前的缓存容量
     */
    private int currentCacheSize;
    /**
     * 缓存的最大容量
     */
    private int cacheCapacity;

    /**
     * 链表的头结点
     */
    private CacheNode head;

    /**
     * 链表的尾节点
     */
    private CacheNode last;

    /**
     * 建立构造函数，初始化LRU的容量和保存节点的Map
     * @param size
     */
    public LRUCache(int size) {
        this.cacheCapacity = size;
        this.currentCacheSize = 0;
        map = new HashMap<K, CacheNode>();
    }

    public void put(K key, V value) {
        // 查看map中是否存储当前key对应的信息
        CacheNode node = map.get(key);
        // 对节点判空
        if (node == null) {
            // 判断是否超过LRU所允许的容量
            if (currentCacheSize >= cacheCapacity) {
                removeLastNode();
            }
            currentCacheSize++;
            node = new CacheNode();
            node.key = key;
        }
        node.value = value;
        // 将新加入的节点移动到头结点
        moveToFirst(node);
        map.put(key, node);
    }

    /**
     * 将当前节点移动到双向链表的前面
     * @param node 需要移动的节点
     */
    public void moveToFirst(CacheNode node) {
        if (node == null) {
            return;
        }

        if (head == null || last == null) {
            head = last = node;
            return;
        }

        if (head == node) {
            return;
        }

        // 如果当前节点是双向链表中的最后一个节点
        if (last == node) {
            last = last.pre;
            last.next = null;
        }

        // 如果node原来存在
        if (node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }


        node.pre = null;
        node.next = head;
        head.pre = node;
        head = node;
    }

    /**
     * 删除双向链表的最后一个节点
     */
    public void removeLastNode() {
        CacheNode t = last;
        last = last.pre;
        // help GC
        t.pre = null;
        last.next = null;
        // 当前LRU缓存的容量减一
        currentCacheSize--;
        // 删除map容器中对应的数据
        map.remove(last);
    }

    /**
     * 获取key对应的值
     * @param key
     * @return
     */
    public V get(K key) {
        CacheNode node = map.get(key);
        if (node == null) {
            return null;
        }

        moveToFirst(node);
        return node.value;
    }

    public void remove(K key) {
        CacheNode node = map.get(key);
        if (node == null) {
            return;
        }

        // 如果node为头结点
        if (node == head) {
            head = node.next;
            node.next = null;
            head.pre = null;
        } else if (node == last) {
        // 如果node为last节点
            CacheNode t = node;
            last = node.pre;
            last.next = null;
            t.pre = null;
        } else {
            // node位于双向链表中间的情况
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        map.remove(key);

        currentCacheSize--;
    }

    public List<V> printLru() {
        List<V> list = new ArrayList<>(currentCacheSize);
        CacheNode currentNode = head;

        while (currentNode != null) {
            list.add(currentNode.value);
            currentNode = currentNode.next;
        }
        return list;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("武雪", 1);
        cache.put("符宜文", 2);
        cache.put("白雪言", 3);
        cache.put("周宇浩", 4);
        cache.remove("周宇浩");
        cache.get("符宜文");
        System.out.println(cache.printLru());
        cache.get("白雪言");
        System.out.println(cache.printLru());
//        cache.get("白雪言");
//        System.out.println(cache.printLru());
    }

}
