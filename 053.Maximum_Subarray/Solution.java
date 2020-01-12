class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //两个变量即可
        int[] dp = new int[2];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            //利用求余，轮换两个变量
            if (dp[(i - 1) % 2] < 0) {
                dp[i % 2] = nums[i];
            } else {
                dp[i % 2] = dp[(i - 1) % 2] + nums[i];
            }
            max = Math.max(max, dp[i % 2]);
        }
        return max;
    }
}