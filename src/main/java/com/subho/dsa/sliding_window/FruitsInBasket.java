package com.subho.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    public static int totalFruit(int[] fruits) {
        int maxLen = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < fruits.length; r++) {
            int fr = fruits[r];
            map.put(fr, map.getOrDefault(fr, 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {

                    int fl = fruits[l];
                    map.put(fl, map.get(fl) - 1);
                    if (map.get(fl) == 0) map.remove(fl);
                    l++;
                }
            }

            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,2,2};
        // System.out.println(totalFruit(nums));
        // int[] nums = {0,1,2,2};
        // System.out.println(totalFruit(nums));
        // int[] nums = {1,2,1};
        // System.out.println(totalFruit(nums));
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(nums));
    }
}
