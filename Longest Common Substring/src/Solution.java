class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                if (ch1 != ch2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}