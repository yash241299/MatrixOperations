/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {
    private int check(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(word1.charAt(i) != word2.charAt(j)) {
                i++;
            } else {
                i++; j++;
            }
        }
        if(j == m) {
            return Math.abs(m-n);
        }
        return -1;
    }
    private String lexoString(String word1, String word2) {
        int n = word1.length();
        int i = 0;
        //System.out.println(word1 +" "+ word2);
        while(i < n) {
            if(word1.charAt(i) < word2.charAt(i)) {
                return word1;
            } else if(word2.charAt(i) < word1.charAt(i)) {
                return word2;
            }
            i++;
        }
        return word1;
    }
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for(String word : dictionary) {
            int len = check(s, word);
            if(len == -1) continue;
            if(word.length() > res.length()) {
                res = word;
            } else if(word.length() == res.length()) {
                res = lexoString(res, word);
            }
        }
        return res;
    }
}
// @lc code=end

