package com.gujie1996.trie;

import java.util.*;

public class WordSearchII {

    Trie trie = new Trie();
    int m;
    int n;
    char[][] board;
    boolean[][] states;

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[] {"oath","pea","eat","rain"};
        List<String> resultList = new WordSearchII().findWords(board, words);
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
        m = board[0].length;
        n = board.length;
        states = new boolean[n][m];
        this.board = board;
        // Set防止结果重复
        Set<String> resultSet = new HashSet<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                dfs(x, y, trie.root, new StringBuilder(), resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    public void dfs(int x, int y, Trie.TrieNode node, StringBuilder builder, Set<String> resultSet) {
        if (x < 0 || y < 0 || x >= m || y >= n || states[y][x]) {
            return;
        }
        char c = board[y][x];
        builder.append(c);
        Trie.TrieNode child = node.map.get(c);
        if (child != null) {
            if (child.isWord) {
                resultSet.add(builder.toString());
            }
            // 无论本次是不是单词，都继续搜索，防止漏掉同前缀单词
            states[y][x] = true;
            dfs(x+1, y, child, builder, resultSet);
            dfs(x-1, y, child, builder, resultSet);
            dfs(x, y+1, child, builder, resultSet);
            dfs(x, y-1, child, builder, resultSet);
            states[y][x] = false;
        }
        // 还原现场
        builder.deleteCharAt(builder.length() - 1);
    }

    class Trie {
        TrieNode root;
        class TrieNode {
            public TrieNode() {
                map = new HashMap<>();
            }
            boolean isWord;
            Map<Character, TrieNode> map;
        }
        public Trie() {
            root = new TrieNode();
            root.map = new HashMap<>();
        }
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                TrieNode child = node.map.get(c);
                if (child == null) {
                    child = new TrieNode();
                    node.map.put(c, child);
                }
                node = child;
            }
            node.isWord = true;
        }
    }

}
