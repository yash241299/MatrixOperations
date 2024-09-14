/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start

import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() <= 1) {
                leaves.add(i);
            }
        }
        
        int remainingNodes = n;
        while(remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                for(int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
// @lc code=end

