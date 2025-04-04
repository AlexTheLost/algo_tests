// 349. Intersection of Two Arrays

// Solution 1 via TreeSet:
https://leetcode.com/problems/intersection-of-two-arrays/solutions/?envType=problem-list-v2&envId=aqw21527
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new TreeSet<Integer>();
        Set<Integer> s2 = new TreeSet<Integer>();

        for (int i=0; i<nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++) {
            s2.add(nums2[i]);
        }

        List<Integer> r = new LinkedList<Integer>();
        for (Integer num1 : s1) {
            if (s2.contains(num1)) {
                r.add(num1);
            }
        }

        int[] result = new int[r.size()];
        for (int i=0; i<r.size(); i++) {
            result[i] = r.get(i);
        }
        return result;
    }
}

// Solution 2 via sort and array:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        // 0 1 2
        // 2 2 3 4

        int nums1_idx = 0;
        int nums2_idx = 0;
        int[] result_max = new int[Math.min(nums1.length, nums2.length)];
        int result_size = 0;
        while (true) {
            if (nums1_idx >= nums1.length || nums2_idx >= nums2.length) {
                break;
            }
            if (nums1[nums1_idx] > nums2[nums2_idx]) {
                nums2_idx++;
            } else if (nums1[nums1_idx] < nums2[nums2_idx]) {
                nums1_idx++;
            } else {
                if (result_size == 0 || result_max[result_size-1] != nums1[nums1_idx]) {
                    result_max[result_size] = nums1[nums1_idx];
                    result_size++;
                }
                nums1_idx++;
                nums2_idx++;
            }
        }

        int[] result = Arrays.copyOf(result_max, result_size);
        return result;
    }
}