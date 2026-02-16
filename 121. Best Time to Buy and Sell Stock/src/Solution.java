class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minDay = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minDay = Math.min(minDay, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minDay);
        }
        return maxProfit;
    }
}