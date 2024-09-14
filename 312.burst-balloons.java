/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    int[] nums;
    Integer[][] dp;
    private int score(int i, int k, int j) {
        int prev = i >= 0 ? nums[i] : 1;
        int next = j < nums.length ? nums[j] : 1;
        return prev * nums[k] * next;
    }

    private int solve(int i, int j) {
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int res = 0;
        for(int k = i; k <= j; k++) {
            int coins = score(i-1, k, j+1) + solve(i, k-1) + solve(k+1, j); 
            res = Math.max(coins, res);
        }
        return dp[i][j] = res;
    }
    public int maxCoins(int[] nums) {
        this.nums = nums;
        this.dp = new Integer[nums.length][nums.length];
        return solve(0, nums.length-1);
    }
}
// @lc code=end

