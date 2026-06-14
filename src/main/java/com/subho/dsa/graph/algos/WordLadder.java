package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordLadder {
    // word ladder 1
    public static int ladderLength(String beginWord, String endWord, List<String> wordListOrg) {

        if(!wordListOrg.contains(endWord)) return 0;
        
        Map<String, Integer> distMap = new HashMap<>();
        List<String> wordList = new ArrayList<>(wordListOrg);
        if(!wordListOrg.contains(beginWord))
            wordList.add(beginWord);
        
        
        for(String word : wordList) {
            distMap.put(word, 99999999);
        }
        distMap.put(beginWord, 0);
        
        Stack<String> st = new Stack<>();
        st.push(beginWord);
        
        Map<String, List<String>> patternMap = createPatternMap(wordList);
        Map<String, Set<String>> adNbrMap = new HashMap<>();

        for(String word : wordList) {
            adNbrMap.put(word, getNbList(word, patternMap));
        }

        while(!st.isEmpty()) {
            String curr = st.pop();

            System.out.println("Curr word " + curr);

            Set<String> adNbrs = adNbrMap.get(curr);

            System.out.println("Neibhors of " + curr + " | " + adNbrs);

            for(String nbr : adNbrs) {

                if(distMap.get(curr) + 1 < distMap.get(nbr)) {
                    distMap.put(nbr, distMap.get(curr) + 1);
                    st.push(nbr);
                }
            }   
        }

        return distMap.get(endWord) == 99999999 ? 0 : distMap.get(endWord) + 1;
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

    private static Set<String> getNbList(String word, Map<String, List<String>> patternMap) {
        Set<String> nbrs = new HashSet<>();

        char[] chars = word.toCharArray();

        for(int i=0; i<chars.length; i++) {
            char original = chars[i];
            
            chars[i] = '*';

            List<String> nbr = patternMap.get(new String(chars));
            if(nbr != null && nbr.size() > 0) {
                nbrs.addAll(nbr);
            }

            chars[i] = original;
        }

        nbrs.remove(word);
        return nbrs;
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
