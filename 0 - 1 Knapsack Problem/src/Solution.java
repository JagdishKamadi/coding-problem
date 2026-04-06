// this will give us the TLE(Time limit exceeded.)
// go for the solution 2
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        return helper(W, val, wt, wt.length - 1);
    }

    private int helper(int W, int[] val, int[] wt, int n) {
        if (W == 0 || n < 0) {
            return 0;
        }
        if (wt[n] > W) {
            return helper(W, val, wt, n - 1);
        } else {
            return Math.max(helper(W, val, wt, n - 1), val[n] + helper(W - wt[n], val, wt, n - 1));
        }
    }
}
