/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        for(int i = n-2; i >= 0; i--) {
            max[i] = Math.max(nums[i+1], max[i+1]);
        }
        int min = nums[0];
        for(int i = 1; i < n-1; i++) {
            if(nums[i] > min && nums[i] < max[i]) {
                return true;
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
// @lc code=end

