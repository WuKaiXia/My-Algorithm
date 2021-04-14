package com.wk.javaalgorithm.leetcode208;


import java.util.HashMap;

/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie0 {
    HashMap<Character, Trie0> children = new HashMap<>();
    String word;

    /**
     * Initialize your data structure here.
     */
    public Trie0() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        Trie0 trie = this;
        char[] chars = word.toCharArray();
        for (Character letter : chars) {
            if (trie.children.containsKey(letter)) {
                trie = trie.children.get(letter);
            } else {
                Trie0 newTrie = new Trie0();
                trie.children.put(letter, newTrie);
                trie = newTrie;
            }
        }
        trie.word = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return false;
        char[] chars = word.toCharArray();
        Trie0 tempTrie = this;
        for (Character letter : chars) {
            tempTrie = tempTrie.children.getOrDefault(letter, null);
            if (tempTrie == null) {
                return false;
            }
        }
        return tempTrie.word != null;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return false;
        char[] chars = prefix.toCharArray();
        Trie0 tempTrie = this;
        for (Character letter : chars) {
            tempTrie = tempTrie.children.getOrDefault(letter, null);
            if (tempTrie == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie0 trieNode = new Trie0();
        trieNode.insert("apple");
        System.out.println("startswith" + trieNode.startsWith("app"));
    }
}
