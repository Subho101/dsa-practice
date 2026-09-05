package com.subho.dsa.binary_search;

public class MedianTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;
        int idx2 = n / 2;
        int idx1 = idx2 - 1;
        int idxEl1 = -1, idxEl2 = -1;
        int count = 0;

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (count == idx1)
                    idxEl1 = nums1[i];
                if (count == idx2)
                    idxEl2 = nums1[i];
                i++;
            } else {
                if (count == idx1)
                    idxEl1 = nums2[j];
                if (count == idx2)
                    idxEl2 = nums2[j];
                j++;
            }

            count++;
        }

        while (i < n1) {
            if (count == idx1)
                idxEl1 = nums1[i];
            if (count == idx2)
                idxEl2 = nums1[i];
            count++;
            i++;
        }

        while (j < n2) {
            if (count == idx1)
                idxEl1 = nums2[j];
            if (count == idx2)
                idxEl2 = nums2[j];
            count++;
            j++;
        }

        if (n % 2 == 0) {
            return ((double) (idxEl1 + idxEl2)) / 2.0;
        } else {
            return (double) idxEl2;
        }
    }

    public static double findMedianSortedArraysBS(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArraysBS(nums2, nums1);

        int low = 0, high = n1;
        int n = n1 + n2;
        int leftPartition = (n1 + n2 + 1) / 2; // both even and odd covers. eg. for 10 elements, split will be 5 and for
                                               // 5 element split will be 3 + 2
        System.out.println("left " + leftPartition);
        while (low <= high) {
            int mid1 = low + (high - low) / 2; // tries to partition the 1st array. Here it is saying I will be taking
                                               // mid1 number of element from 1st array ()
            int mid2 = leftPartition - mid1; // means rest of the element will be taken by 2nd element

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE; // if there is no element in the left part, I want l1 <=
                                                                // r2 / l2 <= r1 to be succedd
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE; // if there is no element in the right part, I want l1
                                                                // <= r2 / l2 <= r1 to be succedd

            System.out.println("mid1 " + mid1 + " mid2 " + mid2);

            if (mid1 < n1)
                r1 = nums1[mid1]; // checking this condition, because it is possible to be mid1 in n1 position
                                  // when all the elements is taken from nums1

            if (mid2 < n2)
                r2 = nums2[mid2];

            if (mid1 - 1 >= 0) // it is possible that no element is taken from nums1 and mid1 is in index 0
                               // (means taken 0 element from the nums1)
                l1 = nums1[mid1 - 1];

            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            // check the valid condition if l1 <= r2 && l2 <= r1 (means we have found a
            // valid partition where all the element in the left is smaller than right part)

            if (l1 <= r2 && l2 <= r1) {
                // check even / odd condition
                if (n % 2 == 0) {
                    // even number, means median will lie between max of left part and min of right
                    // part
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                // since odd number, left part will have one extra element, and max of them will
                // be middle value
                // [1 3] [2 4 5] -- left --> [1 3] [2]
                return (double) Math.max(l1, l2);

            } else if (l1 > r2) {
                // We have too many element from the nums1 in the left part, because max of
                // nums1
                // is greater
                // than min of nums2
                // so we need to give back some element. hence move the partition to the left
                // side
                high = mid1 - 1;
            } else {
                // We have too few element from the nums1 in left part, because in here the
                // condition would be l2 > r1, means max of nums2 is greater than min of nums1
                // So that we need to take back some element from the right of nums1, means
                // moving the partition to the right

                low = mid1 + 1;
            }

        }

        return 0;

    }

    public static void main(String[] args) {
        // int[] nums1 = { 1, 3, 4, 7, 10, 12 }, nums2 = { 2, 3, 6, 15 };
        // int[] nums1 = { 1, 2 }, nums2 = { 3, 4 };
        int[] nums1 = { 2 }, nums2 = {};
        System.out.println(findMedianSortedArraysBS(nums1, nums2));
    }
}
