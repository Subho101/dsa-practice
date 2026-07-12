package com.subho.dsa.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/
*/

public class FindXSum {

    static class Pair implements Comparable<Pair> {
        int elem;
        int freq;

        Pair(int elem, int freq) {
            this.elem = elem;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.freq != o.freq) {
                return Integer.compare(o.freq, this.freq);
            }

            return Integer.compare(o.elem, this.elem);
        }

        @Override
        public String toString() {
            return "elem " + elem + " freq " + freq;
        }
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (i >= k - 1) {
                List<Pair> tempList = new ArrayList<>();
                map.forEach((key, freq) -> {
                    tempList.add(new Pair(key, freq));
                });

                Collections.sort(tempList);
                System.out.println(tempList);

                int xSum = tempList.stream()
                        .limit(x)
                        .mapToInt(p -> p.elem * p.freq)
                        .sum();
                result[i - k + 1] = xSum;
                int startElem = nums[i - k + 1];
                map.put(startElem, map.get(startElem) - 1);
                if (map.get(startElem) == 0) {
                    map.remove(startElem);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {1,1,2,2,3,4,2,3};
        // int k = 6, x = 2;

        int[] nums = {3, 8, 7, 8, 7, 5};
        int k = 2, x = 2;

        System.out.println(Arrays.toString(findXSum(nums, k, x)));
    }
}
