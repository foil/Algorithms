package com.pillow;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private static class Pair {
        int k, v;
        Pair(int k, int v) {this.k = k; this.v = v;};
    }
    private Deque<Pair> queue;
    private Map<Integer, Pair> map;
    int capacity;
    public LRUCache(int capacity) {
        queue = new LinkedList<Pair>();
        map = new HashMap<Integer, Pair>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Pair p = map.get(key);
            queue.remove(p);
            queue.addFirst(p);
            return p.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Pair p = map.get(key);
            p.v = value;
            queue.remove(p);
            queue.addFirst(p);
            return;
        }
        if (queue.size() == capacity) {
            Pair old = queue.pollLast();
            System.out.printf("remove k:%d, v:%d\n", old.k, old.v);
            map.remove(old.k);
        }
        queue.addFirst(new Pair(key, value));
        map.put(key, queue.getFirst());
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        int v = cache.get(2);
        System.out.println(v);
        cache.put(2, 6);
        v = cache.get(1);
        System.out.println(v);
        cache.put(1, 5);
        cache.put(1, 2);
        v = cache.get(1);
        System.out.println(v);
        v = cache.get(2);
        System.out.println(v);
    }
}
