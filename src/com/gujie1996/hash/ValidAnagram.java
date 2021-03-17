package com.gujie1996.hash;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = smap.get(c);
            smap.put(c, count == null ? 1 : ++count);
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer count = tmap.get(c);
            tmap.put(c, count == null ? 1 : ++count);
        }
        return smap.equals(tmap);
    }
    
}