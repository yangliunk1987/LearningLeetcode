class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int num = prices[i] - prices[i - 1];
            dp = Math.max(dp + num, num);
            max = Math.max(max, dp);
        }
        return max;
    }
}