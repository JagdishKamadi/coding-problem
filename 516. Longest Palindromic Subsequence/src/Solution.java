class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        int topLeft = dp[i][j - 1];
                        int bottomRight = dp[i + 1][j];
                        dp[i][j] = Math.max(topLeft, bottomRight);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = "cbbd";
        System.out.println(solution.longestPalindromeSubseq(string));
    }
}