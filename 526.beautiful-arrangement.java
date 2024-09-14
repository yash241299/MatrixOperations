/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    int n;
    private int solve(int i, int mask) {
        if(i == 0) {
            return 1;
        }
        int res = 0;
        for(int j = 1; j <= n; j++) {
            if((j%i == 0 || i%j == 0) && (((1 << j-1) & mask) == 0)) {
                res += solve(i-1, (mask ^ (1 << j-1)));
            }
        }
        return res;
    }
    public int countArrangement(int n) {
        this.n = n;
        return solve(n, 0);
    }
}
// @lc code=end

