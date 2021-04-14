package com.wk.javaalgorithm.leetcode208;

public class Trie {

    private Trie[] tries;
    boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        tries = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        int length = word.length();
        Trie trie = this;
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (trie.tries[index] == null) {
                Trie newTrie = new Trie();
                trie.tries[index] = newTrie;
            }
            trie = trie.tries[index];
        }
        trie.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        if (prefix == null || prefix.isEmpty()) return null;
        int length = prefix.length();
        Trie trie = this;
        for (int i = 0; i < length; i++) {
            char ch = prefix.charAt(i);
            Trie childTrie = trie.tries[ch - 'a'];
            if (childTrie == null) {
                return null;
            }
            trie = childTrie;
        }
        return trie;
    }
}
