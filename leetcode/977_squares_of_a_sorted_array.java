// Solution 1:
// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1594819737/

class Solution {
    public int[] sortedSquares(int[] nums) {
        // [] -> []
        // [0] -> 0
        // [-1] -> 1
        // [1] -> 1
        // [1 2 3] -> 1 4 9
        // [-10 1 2 3] -> 1 4 9 100
        // [-3 -2 -1 10] -> 1 4 9 100
        // [-10 -1 3 4 5] -> 1 9 16 25 100

        int second_subarray_start_idx = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] < 0) {
                second_subarray_start_idx++;
            }
            nums[i] = nums[i] * nums[i];
        }

        int idx_of_first_end = second_subarray_start_idx - 1;
        int idx_of_second_start = second_subarray_start_idx;

        int[] result = new int[nums.length];

        for (int i=0;i<result.length;i++){
            if(idx_of_first_end >=0 && idx_of_second_start < nums.length) {
                int f = nums[idx_of_first_end];
                int s = nums[idx_of_second_start];
                if (f < s) {
                    result[i] = f;
                    idx_of_first_end--;
                } else {
                    result[i] = s;
                    idx_of_second_start++;
                }
            } else if(idx_of_first_end < 0 && idx_of_second_start < nums.length) {
                result[i] = nums[idx_of_second_start];
                idx_of_second_start++;
            } else if(idx_of_first_end >= 0 && idx_of_second_start >= nums.length) {
                result[i] = nums[idx_of_first_end];
                idx_of_first_end--;
            } else {
                break;
            }
        }
        return result;
    }
}

// Solution 2, without modification source array:
// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1594948798/
class Solution {
    public int[] sortedSquares(int[] nums) {
        // [] -> []
        // [0] -> 0
        // [-1] -> 1
        // [1] -> 1
        // [1 2 3] -> 1 4 9
        // [-10 1 2 3] -> 1 4 9 100
        // [-3 -2 -1 10] -> 1 4 9 100
        // [-10 -1 3 4 5] -> 1 9 16 25 100

        int second_subarray_start_idx = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] < 0) {
                second_subarray_start_idx++;
            }
        }

        int idx_of_first_end = second_subarray_start_idx - 1;
        int idx_of_second_start = second_subarray_start_idx;

        int[] result = new int[nums.length];

        for (int i=0;i<result.length;i++){
            if(idx_of_first_end >=0 && idx_of_second_start < nums.length) {
                int f = Math.abs(nums[idx_of_first_end]);
                int s = Math.abs(nums[idx_of_second_start]);
                if (f < s) {
                    result[i] = f*f;
                    idx_of_first_end--;
                } else {
                    result[i] = s*s;
                    idx_of_second_start++;
                }
            } else if(idx_of_first_end < 0 && idx_of_second_start < nums.length) {
                result[i] = nums[idx_of_second_start]*nums[idx_of_second_start];
                idx_of_second_start++;
            } else if(idx_of_first_end >= 0 && idx_of_second_start >= nums.length) {
                result[i] = nums[idx_of_first_end]*nums[idx_of_first_end];
                idx_of_first_end--;
            } else {
                break;
            }
        }
        return result;
    }
}