package com.subho.dsa.two_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArray {
    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        Set<Integer> resultSet = new HashSet<>();
        int i = 0, j = 0;
        while (i < m && j < n) {

            System.out.println(nums1[i] + " " + nums2[j]);
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int e : resultSet) result[k++] = e;
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
