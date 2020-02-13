class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        int sell = 1;

        for (; sell < prices.length; sell++) {
            //出现下跌
            if (prices[sell] < prices[sell - 1]) {
                //不是第 2 天下跌，就前一天卖出，累计收益
                if (sell != 1) {
                    profit += prices[sell - 1] - prices[buy];
                }
                //下跌当天再次买入
                buy = sell;

            //到最后一天是上涨，那就在最后一天卖出
            } else if (sell == prices.length - 1) {
                profit += prices[sell] - prices[buy];
            }
        }
        return profit;
    }
}