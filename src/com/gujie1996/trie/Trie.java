package com.gujie1996.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    TrieNode root;

    class TrieNode {
        public TrieNode() {
            map = new HashMap<>();
        }
        boolean isWord;
        Map<Character, TrieNode> map;
    }


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.map.get(c);
            if (node == null) {
                break;
            }
        }
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.map.get(c);
            if (node == null) {
                break;
            }
        }
        return node != null;
    }

}
