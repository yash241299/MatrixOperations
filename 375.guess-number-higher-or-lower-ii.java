/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
    int[][] dp;
    private int solve(int low, int high) {
        if(low >= high) {
            return 0;
        }
        if(dp[low][high] != -1) {
            return dp[low][high];
        }
        int res = Integer.MAX_VALUE;
        for(int i = low; i <= high; i++) {
            int cost = i + Math.max(solve(low, i - 1), solve(i + 1, high));
            res = Math.min(res, cost);
        }
        return dp[low][high] = res;
    }
    public int getMoneyAmount(int n) {
        this.dp = new int[n+1][n+1];
        for(int[] x : this.dp) {
            Arrays.fill(x, -1);
        }
        return solve(1, n);
    }
}
// @lc code=end

