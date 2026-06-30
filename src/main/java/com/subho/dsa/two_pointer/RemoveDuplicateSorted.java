package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class RemoveDuplicateSorted {
    public static int removeDuplicate(int[] arr) {
        int low = 0;

        for(int high = 0; high < arr.length; high++) {
            if(arr[low] != arr[high]) {
                low++;
                arr[low] = arr[high];
            }
        }

        return low+1;
    }

    public static int removeDuplicateII(int[] arr) {
        int i = 0;

        for(int x : arr) {
            if(i == 0 || i == 1 || arr[i-2] != x) {
                arr[i] = x;
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int result = removeDuplicateII(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}
