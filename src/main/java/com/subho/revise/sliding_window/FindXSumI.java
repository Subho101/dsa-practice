package com.subho.revise.sliding_window;

/*
https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/

You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

    Count the occurrences of all elements in the array.
    Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
    Calculate the sum of the resulting array.

Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

 

Example 1:

Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

Output: [6,10,12]

Explanation:

    For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
    For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
    For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.

*/

import java.util.*;

public class FindXSumI {
    /*
    * Declaring a pair class, which will store the elem and its frequency
    * */

    static class Pair implements Comparable<Pair> {
        int elem;
        int freq;

        Pair(int elem, int freq) {
            this.elem = elem;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.freq != o.freq) {
                return Integer.compare(o.freq, this.freq);
            }

            return Integer.compare(o.elem, this.elem);
        }
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            // Putting the current element into the freqMap
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if(i >= k-1) { // Its hit the current window size

                /*
                * Once it has hit the required window size k
                * I will traverse the map and create a tempList from those map elem and freq
                * I will sort them based on the criteria
                * Calculate sum of the top x element
                * Put the sum in i-k+1 index in result
                * Get the first element from the original array to remove, since need to move the window
                * Decrement the frequency, if freq == 0, remove the element from the map
                * */

                List<Pair> tempList = new ArrayList<>();
                freqMap.forEach((key, val) -> tempList.add(new Pair(key, val)));
                Collections.sort(tempList);

                int xSum = tempList.stream().limit(x).mapToInt(p -> p.elem * p.freq).sum();
                result[i-k+1] = xSum;
                int startElem = nums[i-k+1];
                freqMap.put(startElem, freqMap.get(startElem) - 1);
                if(freqMap.get(startElem) == 0) freqMap.remove(startElem);

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6, x = 2;

        System.out.println(Arrays.toString(findXSum(nums, k, x)));
    }
}
