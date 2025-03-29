// 485. Max Consecutive Ones
// https://leetcode.com/problems/max-consecutive-ones/description/?envType=problem-list-v2&envId=aqw21527

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1) {
                counter++;
                if (counter > max) {
                    max = counter;
                }
            } else {
                counter = 0;
            }
        }
        return max;
    }
}