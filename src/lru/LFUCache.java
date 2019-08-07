package lru;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/7/24 0024
 */
public class LFUCache<T> {

    /**
     * LFU节点，存储于优先级队列当中
     * @param <T>
     */
    class LFUCacheNode<T> implements Comparable<LFUCacheNode<T>> {

        private int useCount;

        T cacheObject;

        LocalDateTime createTime;

        LocalDateTime updateTime;

        public LFUCacheNode(T cacheObject) {
            this.cacheObject = cacheObject;
            this.useCount++;
            this.createTime = LocalDateTime.now();
            this.updateTime = LocalDateTime.now();
        }

        public int getUseCount() {
            return this.useCount;
        }

        @Override
        public int compareTo(LFUCacheNode<T> o) {
            return this.getUseCount() - o.getUseCount();
        }
    }
}

