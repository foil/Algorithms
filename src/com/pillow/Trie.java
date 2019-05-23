package com.pillow;
import java.util.Map;
import java.util.HashMap;

class Trie {
    private Map<Character, Trie> map;
    private boolean isLeaf;
    
    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
        isLeaf = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.isEmpty()) {
            isLeaf = true;
            return;
        }
        char c = word.charAt(0);
        Trie t = map.get(c);
        if (t == null) {
            t = new Trie();
            map.put(c, t);
        }
        t.insert(word.substring(1));
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty())
            return isLeaf;
        Trie t = map.get(word.charAt(0));
        if (t == null)
            return false;
        return t.search(word.substring(1));
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty())
            return true;
        Trie t = map.get(prefix.charAt(0));
        if (t == null)
            return false;
        return t.startsWith(prefix.substring(1));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");   
        System.out.println(trie.search("app"));     // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
