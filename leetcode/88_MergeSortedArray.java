// 88. Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=aqw21527

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n ==0) {
            return;
        }
        for (int i=m,j=0;i<m+n;i++, j++){
            nums1[i]=nums2[j];
        }
        if (nums1.length <= 1) {
            return;
        }
        Arrays.sort(nums1);
        // System.out.println(Arrays.toString(nums1));
    }
}