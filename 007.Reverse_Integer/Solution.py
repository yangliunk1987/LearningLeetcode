class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        positive = True
        if x < 0:
            positive = False
        x = abs(x)
        ans = 0
        while x > 0:
            ans = ans * 10 + x % 10
            x //= 10
        if ans > 2147483647:
            return 0
        if not positive:
            return -1*ans
        return ans