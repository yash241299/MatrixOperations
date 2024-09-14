/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
import java.util.*;
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, ans = 0;
        List<Map<Integer, Integer>> dists = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + 
                    (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
         
                    map.put(dist, map.getOrDefault(dist, 0)+1);
                }
            }
            dists.add(map);
        }
        for(int i = 0; i < n; i++) {
            for(Map.Entry<Integer, Integer> pair : dists.get(i).entrySet()) {
                int m = pair.getValue();
                if(m > 1) {
                    ans += (m * (m-1));
                }
            }
        }
        //System.out.println(dists);
        return ans;
    }
}
// @lc code=end

