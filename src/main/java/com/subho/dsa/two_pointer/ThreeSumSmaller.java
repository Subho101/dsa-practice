package com.subho.dsa.two_pointer;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static int countTriplets(int sum, int arr[]) {
        int count = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            int j = i+1;
            int k = arr.length - 1;
            
            while(j < k) {
                int s = arr[i] + arr[j] + arr[k];
                if(s < sum) {
                    count += k - j;
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(countTriplets(target, arr));
    }
}
