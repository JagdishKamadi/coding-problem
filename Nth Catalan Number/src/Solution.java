
class Solution {
    public static int findCatalan(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findCatalan(4));
        System.out.println(Solution.findCatalan(6  ));
    }
}
