package Y2020.linkedin.algo_part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Q013_Implement_Hashtable {


    interface Hashtable {
        V get(K key);

        void put(K key, V val);
    }

    class Htable<K extends Q013_Implement_Hashtable.K, V extends Q013_Implement_Hashtable.V> {

        private int numBucket;
        private ArrayList<List<Node>> buckets;
        private ArrayList<ReadWriteLock> locks;

        public Htable(int numBucket) {
            this.numBucket = numBucket;
            buckets = new ArrayList<List<Node>>(numBucket);
            locks = new ArrayList<ReadWriteLock>(numBucket);
            for (int i = 0; i < numBucket; i++) {
                buckets.set(i, new LinkedList<Node>());
                locks.set(i, new ReentrantReadWriteLock());
            }
        }

        public V get(K key) {
            int idx = getBucketIdx(key);
            locks.get(idx).readLock().lock();
            List<Node> bucket = buckets.get(idx);

            V rslt = null;

            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    rslt = (V) node.val;
                    break;
                }
            }

            locks.get(idx).readLock().unlock();

            return rslt;
        }

        public void put(K key, V val) {
            int idx = getBucketIdx(key);
            locks.get(idx).writeLock().lock();

            List<Node> bucket = buckets.get(idx);
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    node.val = val;
                }
            }
            bucket.add(new Node(key, val));

            locks.get(idx).writeLock().unlock();
        }


        private int getBucketIdx(K key) {
            int hasCode = key.hashCode();
            int idx = Math.abs(hasCode % numBucket);
            return idx;
        }

    }


    class Node {
        K key;
        V val;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    interface K {
        int hashCode();
        boolean equals(K k);
    }

    interface V {
        boolean equals(K k);
    }


}