class Solution(object):
    def climbStairs(self, n):
        if n <= 1:
            return 1
        dp = [1] * 2
        for i in range(2, n + 1):
            dp[1], dp[0] = dp[1] + dp[0], dp[1]
        return dp[1]