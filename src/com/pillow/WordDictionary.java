package com.pillow;

import java.util.Arrays;
import java.util.Objects;

public class WordDictionary {
    class Trie {
        Trie[] trie = null;
        Trie add(char c) {
            if (trie == null)
                trie = new Trie[26];
            if (trie[c - 'a'] == null)
                trie[c - 'a'] = new Trie();

            return trie[c - 'a'];
        }
        Trie search(char c) {
            if (trie == null)
                return null;
            return trie[c - 'a'];
        }
        Trie[] all() {
            if (trie == null)
                return new Trie[0];
            return Arrays.stream(trie).filter(Objects::nonNull).toArray(Trie[]::new);
        }
    }
    /** Initialize your data structure here. */
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie t = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            t = t.add(c);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int idx, Trie root) {
        if (idx == word.length())
            return true;
        if (root != null) {
            char c = word.charAt(idx);
            if (c == '.') {
                for (Trie t: root.all()) {
                    if (search(word, idx+1, t))
                        return true;
                }
                return false;
            }
            Trie t = root.search(c);
            if (t == null)
                return false;
            return search(word, idx+1, t);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();

        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("add");
        System.out.println(obj.search("a"));
        System.out.println(obj.search(".at"));
        obj.addWord("bat");
        System.out.println(obj.search(".at"));
        System.out.println(obj.search("an."));
        System.out.println(obj.search("a.d."));
        System.out.println(obj.search("b."));
        System.out.println(obj.search("a.d"));
        System.out.println(obj.search("."));
    }
}
