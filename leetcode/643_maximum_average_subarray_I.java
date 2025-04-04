// 643. Maximum Average Subarray I
// https://leetcode.com/problems/maximum-average-subarray-i/?envType=problem-list-v2&envId=aqw21527

class Solution {
    private int sum(int[] nums, int from, int until) {
        int sum = 0;
        for (int i=from;i<until;i++){
            sum+=nums[i];
        }
        return sum;
    }

    public double findMaxAverage(int[] nums, int k) {
        int current_sum = sum(nums, 0, k);
        double max_avg = (double) current_sum / k;
        for (int i=k;i<nums.length;i++){
            current_sum -= nums[i-k];
            current_sum += nums[i];
            double avg = (double) current_sum / k;
            if (avg > max_avg) {
                max_avg = avg;
            }
        }
        return max_avg;
    }
}