package com.subho.dsa.graph.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet djs = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    int ulp_u = djs.findParent(map.get(email));
                    djs.unionByRank(ulp_u, i);
                } else {
                    map.put(email, i);
                }
            }
        }

        System.out.println(map);

        int[] parent = djs.parent;
        System.out.println(Arrays.toString(parent));

        List<List<String>> mailList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mailList.add(new ArrayList<>());
        }

        map.forEach((mail, idx) -> {
            int parentNode = djs.findParent(idx);
            mailList.get(parentNode).add(mail);
        });

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> mergedMail = mailList.get(i);
            if (mergedMail.size() == 0) continue;
            Collections.sort(mergedMail);
            List<String> tempList = new ArrayList<>();
            tempList.add(accounts.get(i).get(0));
            tempList.addAll(mergedMail);
            result.add(tempList);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com"));

        List<List<String>> result = accountsMerge(accounts);
        System.out.println(result);
    }
}
