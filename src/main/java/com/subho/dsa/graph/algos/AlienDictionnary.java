package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionnary {

    public static String findOrder(String[] dict) {

        Set<Character> uniqueChars = new HashSet<>();
        for (String str : dict) {
            for (char ch : str.toCharArray()) {
                uniqueChars.add(ch);
            }
        }
        Map<Character, Set<Character>> adList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (char ch : uniqueChars) {
            adList.put(ch, new HashSet<>());
            indegree.put(ch, 0);
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String first = dict[i];
            String second = dict[i + 1];
            boolean foundDiff = false;

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                char src = first.charAt(j);
                char dest = second.charAt(j);
                if (src != dest) {
                    Set<Character> nbrs = adList.get(src);
                    nbrs.add(dest);
                    adList.put(src, nbrs);
                    foundDiff = true;
                    break;
                }
            }

            if (!foundDiff && first.length() > second.length()) return "";
        }

        adList.forEach((src, nbrs) -> {
            for (char nbr : nbrs) {
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        });

        Queue<Character> q = new LinkedList<>();
        indegree.forEach((node, degree) -> {
            if (degree == 0) q.offer(node);
        });

        List<String> resultOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            char curr = q.poll();
            resultOrder.add(String.valueOf(curr));

            for (char nbr : adList.get(curr)) {
                indegree.put(nbr, indegree.get(nbr) - 1);
                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }

        System.out.println(adList);
        System.out.println(indegree);
        System.out.println(resultOrder);

        return resultOrder.size() == uniqueChars.size() ? String.join("", resultOrder) : "";
    }

    public static void main(String[] args) {
        // String[] dict = {"baa","abcd","abca","cab","cad"};
        String[] dict = {
            "aaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaa",
            "a",
            "aaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaa",
            "aaaa",
            "aaaaaaaaaaa",
            "aaaaa",
            "aaaaaaaaaaa",
            "aaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaa",
            "aaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaa",
            "aaaaaaaaa",
            "aaaaa",
            "aaaaaaaaaaaaaaaaaaa"
        };
        String result = findOrder(dict);
        System.out.println("Result " + result);
    }
}
