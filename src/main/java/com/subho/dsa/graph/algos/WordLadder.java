package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    static class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    // word ladder 1
    public static int ladderLength(String beginWord, String endWord, List<String> wordListOrg) {

        if(!wordListOrg.contains(endWord)) return 0;
        
        List<String> wordList = new ArrayList<>(wordListOrg);
        if(!wordListOrg.contains(beginWord)) wordList.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        visited.add(beginWord);
        
        Map<String, List<String>> patternMap = createPatternMap(wordList);

        while(!q.isEmpty()) {
            
            Pair currP = q.poll();
            String curr = currP.word;
            int currLevel = currP.level;

            if(curr.equals(endWord)) return currLevel;

            char[] chars = curr.toCharArray();

            for(int i=0; i<chars.length; i++) {
                char original = chars[i];
                chars[i] = '*';
                String pattern = new String(chars);

                List<String> nbrs = patternMap.getOrDefault(pattern, Collections.emptyList());

                for(String nbr : nbrs) {
                    if(!visited.contains(nbr)) {
                        visited.add(nbr);
                        q.offer(new Pair(nbr, currLevel + 1));
                    }
                }

                patternMap.remove(pattern);
                chars[i] = original;

            }

            System.out.println("Curr word " + curr);

              
        }

        //return distMap.get(endWord) == 99999999 ? 0 : distMap.get(endWord) + 1;
        return 0;
    }

    private static Map<String, List<String>> createPatternMap(List<String> wordList) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for(String word : wordList) {
            char[] chars = word.toCharArray();

            for(int i=0; i<chars.length; i++) {

                char original = chars[i];
                chars[i] = '*';

                String pattern = new String(chars);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
                chars[i] = original;
            }
        }

        System.out.println(patternMap);
        return patternMap;
    }

    public static void main(String[] args) {
        //List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        List<String> wordList = List.of("hot","dog");
        // Map<String, List<String>> mp = createPatternMap(wordList);
        // Set<String> nbrs = getNbList("dot", mp);
        // System.out.println(nbrs);
        //String beginWord = "hit", endWord = "cog";
        String beginWord = "hot", endWord = "dog";
        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }
}
