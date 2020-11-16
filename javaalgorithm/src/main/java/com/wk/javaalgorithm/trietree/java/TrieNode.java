package com.wk.javaalgorithm.trietree.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {
    }

    /**
     * 构建前缀树字典
     *
     * @param words 原始数组
     * @return 前缀树字典
     */
    public static TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            node = insertTrie(word, node);
            node.word = word;
        }

        return root;
    }

    /**
     * 插入节点数据
     *
     * @param word 原始数据
     * @param node 根节点对象
     * @return 转换后的前缀树字典
     */
    private static TrieNode insertTrie(String word, TrieNode node) {
        for (Character letter : word.toCharArray()) {
            if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
                node = newNode;
            }
        }
        return node;
    }

    /**
     * 遍历查找是否包含单词字符串
     *
     * @param word 索引字符串
     * @param node 前缀树字典
     * @return false 不包含索引字符串； true 包含索引字符串
     */
    private static boolean searchTrie(String word, TrieNode node) {
        if (word == null || word.isEmpty()) return false;
        char[] chars = word.toCharArray();
        for (char letter : chars) {
            TrieNode tempNode = node.children.getOrDefault(letter, null);
            if (tempNode == null) {
                return false;
            }
            node = tempNode;
        }
        return node.word != null;
    }

    /**
     * 遍历搜索是否包含字符串前缀
     *
     * @param word 单词前缀
     * @param node 前缀树字典
     * @return 不包含单词前缀； true 包含单词前缀
     */
    private static boolean startWith(String word, TrieNode node) {
        if (word == null || word.isEmpty()) return false;
        char[] chars = word.toCharArray();
        for (char letter : chars) {
            TrieNode tempNode = node.children.getOrDefault(letter, null);
            if (tempNode == null) return false;
            node = tempNode;
        }
        return true;
    }

    public static void main(String[] args) {
//        TrieNode trie = TrieNode.createTrie(new String[]{"aaa"});
        TrieNode trieNode = new TrieNode();
        char[][] test = new char[1][2];
        test[0] = new char[]{'a', 'a'};
        trieNode.findWords(test,new String[]{"aaa"});
    }

    ArrayList<String> _result = new ArrayList<>();
    char[][] _board;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode node = createTrie(words);
        this._board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (node.children.containsKey(board[row][col])) {
                    backtracking(row, col, node);
                }
            }
        }
        return _result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currentNode = parent.children.get(letter);

        if (currentNode.word != null) {
            this._result.add(currentNode.word);
            currentNode.word = null;
        }

        // 搜索之前标记该位置的字符
        this._board[row][col] = '#';

        // 左 右 上 下
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newCol < 0 || newRow >= this._board.length || newCol >= this._board[0].length) {
                continue;
            }
            if (currentNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currentNode);
            }
        }

        // 搜索结束后重置标记字符
        this._board[row][col] = letter;

        // 优化： 删除叶节点
        if (currentNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}


