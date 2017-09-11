package com.pillow;

public class MagicDictionary {
    /** Initialize your data structure here. */
    private String[] dict;
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dict = dict;
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (dict == null || dict.length == 0 || word == null)
            return false;
        for (String str : dict) {
            if (str.length() != word.length())
                continue;
            int diff = 0;
            for (int i = 0; i < str.length(); i ++) {
                if (str.charAt(i) != word.charAt(i))
                    diff++;
            }
            if (diff == 1)
                return true;
        }
        return false;
    }
}
