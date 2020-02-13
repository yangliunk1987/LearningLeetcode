class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        #阶乘
        def factorial(n):
            if n == 0:
                return 1
            else:
                return n * factorial(n - 1)

        def dfs(remain, s, n, k):
            if n==1:
                return s+remain[0]

            div = factorial(n-1)
            ind = k//div
            k = k%div
            return dfs(remain[:ind]+remain[ind+1:], s+remain[ind],n-1,k)
            
        return dfs([str(i) for i in range(1,n+1)],'',n,k-1)